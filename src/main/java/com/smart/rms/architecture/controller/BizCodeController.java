package com.smart.rms.architecture.controller;

import com.smart.rms.architecture.model.TbBizCode;
import com.smart.rms.architecture.service.BizCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/biz-code")
public class BizCodeController {

    private final BizCodeService bizCodeService;

    public BizCodeController(BizCodeService bizCodeService) {
        this.bizCodeService = bizCodeService;
    }

    // 전체 목록
    @GetMapping
    public List<TbBizCode> findAll() {
        return bizCodeService.findAll();
    }

    // 단건 조회
    @GetMapping("/{id}")
    public TbBizCode findById(@PathVariable Long id) {
        return bizCodeService.findById(id);
    }

    // 등록
    // 기존 service.save(...) 는 int 반환(행수),
    // 하지만 code.bizSeq 에 새 PK 가 들어오므로, controller 에서 long 을 리턴.
    @PostMapping
    public long save(@RequestBody TbBizCode code) {
        // Insert
        int rows = bizCodeService.save(code);
        // code.bizSeq에는 selectKey를 통해 시퀀스가 들어있음
        long newSeq = code.getBizSeq(); // 실제 PK
        return newSeq;
    }


    // 수정
    @PutMapping("/{id}")
    public int update(@PathVariable Long id, @RequestBody TbBizCode code) {
        code.setBizSeq(id);
        return bizCodeService.update(code);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return bizCodeService.deleteById(id);
    }

    // ✅ 정렬 저장 API 추가
    @PutMapping("/order")
    public void updateOrder(@RequestBody List<TbBizCode> list) {
        bizCodeService.updateOrder(list, "admin"); // 또는 인증된 사용자
    }
    @PostMapping("/check-sys-code")
    public Map<String, Boolean> checkSysCode(@RequestBody TbBizCode code) {
        boolean exists = bizCodeService.isSysCodeExists(code);
        return Map.of("exists", exists);
    }

    @GetMapping("/flat-list")
    public List<Map<String, Object>> getFlatSystemList() {
        return bizCodeService.findFlatSystemList();
    }

}