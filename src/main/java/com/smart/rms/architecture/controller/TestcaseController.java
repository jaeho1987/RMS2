package com.smart.rms.architecture.controller;

import com.smart.rms.architecture.model.TbTestcase;
import com.smart.rms.architecture.service.TestcaseService;
import com.smart.rms.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
@RequiredArgsConstructor
public class TestcaseController {

    private final TestcaseService testcaseService;

    @GetMapping
    public List<TbTestcase> getByReqSeq(@RequestParam Long reqSeq) {
        return testcaseService.findByReqSeq(reqSeq);
    }

    @GetMapping("/{id}")
    public TbTestcase getById(@PathVariable Long id) {
        return testcaseService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TbTestcase testcase) {
        TbTestcase result = testcaseService.insert(testcase);
        return ApiUtil.success(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TbTestcase testcase) {
        testcase.setTestSeq(id);
        int result = testcaseService.update(testcase);
        return ApiUtil.success(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        int result = testcaseService.deleteById(id);
        return ApiUtil.success(result);
    }

    @PutMapping("/order")
    public ResponseEntity<?> updateOrderBatch(@RequestBody List<TbTestcase> list) {
        int result = testcaseService.updateOrderBatch(list);
        return ApiUtil.success(result); // 성공 건수 반환
    }

}
