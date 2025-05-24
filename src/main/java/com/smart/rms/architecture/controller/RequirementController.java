package com.smart.rms.architecture.controller;

import com.smart.rms.architecture.model.TbRequirement;
import com.smart.rms.architecture.service.RequirementService;
import com.smart.rms.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/requirement")
@RequiredArgsConstructor
public class RequirementController {

    private final RequirementService service;

    // 목록 조회
    @GetMapping
    public List<TbRequirement> getList(@ModelAttribute TbRequirement cond) {
        return service.findByCondition(cond);
    }

    // 단건 조회
    @GetMapping("/{id}")
    public TbRequirement getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody TbRequirement req) {
        TbRequirement result = service.insert(req);
        return ApiUtil.success(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TbRequirement req) {
        req.setReqSeq(id);
        int result = service.update(req);
        return ApiUtil.success(result);  // 수정된 건수 또는 reqSeq 등
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        int result = service.deleteById(id);
        return ApiUtil.success(result);  // 삭제된 건수
    }

    @PutMapping("/order")
    public ResponseEntity<?> updateOrderBatch(@RequestBody List<TbRequirement> list) {
        int result = service.updateOrderBatch(list);
        return ApiUtil.success(result);  // 성공 건수
    }

    @GetMapping("/flat-list")
    public ResponseEntity<?> getFlatRequirementList(@RequestParam Long bizSeq) {
        List<Map<String, Object>> list = service.findFlatRequirementList(bizSeq);
        return ApiUtil.success(list);
    }

}
