package com.smart.rms.architecture.controller;
import com.smart.rms.architecture.model.TbRequirement;
import com.smart.rms.architecture.service.RequirementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 등록
    @PostMapping
    public long insert(@RequestBody TbRequirement req) {
        service.insert(req);
        return req.getReqSeq();
    }

    // 수정
    @PutMapping("/{id}")
    public int update(@PathVariable Long id, @RequestBody TbRequirement req) {
        req.setReqSeq(id);
        return service.update(req);
    }

    // 삭제 (논리 삭제)
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    // 정렬 순서 저장
    @PutMapping("/order")
    public int updateOrderBatch(@RequestBody List<TbRequirement> list) {
        return service.updateOrderBatch(list);
    }
}