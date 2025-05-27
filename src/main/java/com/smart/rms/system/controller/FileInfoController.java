package com.smart.rms.system.controller;

import com.smart.rms.system.model.TbFileInfo;
import com.smart.rms.system.service.FileInfoService;
import com.smart.rms.util.ApiUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/fileInfo")
@RequiredArgsConstructor
public class FileInfoController {

    private final FileInfoService fileInfoService;

    @Value("${file.upload-dir}")
    private String uploadDir;


    // ✅ 파일 메타정보 목록 조회
    @GetMapping
    public ResponseEntity<?> findByKeyword(@ModelAttribute TbFileInfo fileInfo) {
        return ApiUtil.success(fileInfoService.findByKeyword(fileInfo));
    }

    // ✅ 파일 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ApiUtil.success(fileInfoService.findById(id));
    }

    // ✅ 파일 메타정보 등록
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody TbFileInfo fileInfo) {
        fileInfo.setDelYn("N");
        return ApiUtil.success(fileInfoService.insert(fileInfo));
    }

    // ✅ 파일 메타정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TbFileInfo fileInfo) {
        fileInfo.setFileSeq(id);
        return ApiUtil.success(fileInfoService.update(fileInfo));
    }

    // ✅ 파일 논리 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ApiUtil.success(fileInfoService.delete(id));
    }

    // ✅ 실제 파일 업로드 + DB 등록
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam Long refSeq,
            @RequestParam String fileType
    ) {
        if (file.isEmpty()) return ResponseEntity.badRequest().body("파일이 없습니다.");

        try {
            String originalName = file.getOriginalFilename();
            String ext = Optional.ofNullable(originalName)
                    .filter(f -> f.contains("."))
                    .map(f -> f.substring(originalName.lastIndexOf(".") + 1))
                    .orElse("");

            String uuidName = UUID.randomUUID().toString() + "." + ext;

            // ✅ 경로 보정: 운영체제에 맞는 절대 경로로 전환
            String saveDir = Paths.get(uploadDir).toAbsolutePath().toString();

            File dir = new File(saveDir);
            if (!dir.exists()) dir.mkdirs();

            String fullPath = Paths.get(saveDir, uuidName).toString(); // OS에 맞는 구분자 사용

            // 실제 파일 저장
            file.transferTo(new File(fullPath));

            // 메타정보 저장
            TbFileInfo fileInfo = new TbFileInfo();
            fileInfo.setRefSeq(refSeq);
            fileInfo.setFileType(fileType);
            fileInfo.setOriginalName(originalName);
            fileInfo.setFileName(uuidName);
            fileInfo.setFilePath(saveDir.endsWith(File.separator) ? saveDir : saveDir + File.separator);
            fileInfo.setFileExt(ext);
            fileInfo.setFileSize(file.getSize());
            fileInfo.setDelYn("N");

            fileInfoService.insert(fileInfo);

            return ApiUtil.success(fileInfo);
        } catch (Exception e) {
            log.error("파일 업로드 실패", e);
            return ResponseEntity.internalServerError().body("업로드 실패");
        }
    }

    // ✅ 파일 다운로드
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        try {
            TbFileInfo fileInfo = fileInfoService.findById(id);
            if (fileInfo == null || "Y".equalsIgnoreCase(fileInfo.getDelYn())) {
                return ResponseEntity.notFound().build();
            }

            String fullPath = fileInfo.getFilePath() + fileInfo.getFileName();
            File file = new File(fullPath);

            if (!file.exists()) return ResponseEntity.notFound().build();

            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + URLEncoder.encode(fileInfo.getOriginalName(), "UTF-8") + "\"")
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (Exception e) {
            log.error("파일 다운로드 실패", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
