package com.smart.rms.architecture.controller;

import com.smart.rms.architecture.model.TbProcFunctionMap;
import com.smart.rms.architecture.service.ProcFunctionMapService;
import com.smart.rms.util.ApiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/procFunctionMap")
@RequiredArgsConstructor
public class ProcFunctionMapController {

    private final ProcFunctionMapService procFunctionMapService;

    @GetMapping
    public List<TbProcFunctionMap> findByKeyword(@ModelAttribute TbProcFunctionMap procFunctionMap) {
        return procFunctionMapService.findByKeyword(procFunctionMap);
    }

    @GetMapping("/{id}")
    public TbProcFunctionMap findById(@PathVariable Long id) {
        return procFunctionMapService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody TbProcFunctionMap procFunctionMap) {
        procFunctionMap.setDelYn("N");
        return ApiUtil.success(procFunctionMapService.insert(procFunctionMap));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TbProcFunctionMap procFunctionMap) {
        procFunctionMap.setProcFncSeq(id);
        return ApiUtil.success(procFunctionMapService.update(procFunctionMap));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ApiUtil.success(procFunctionMapService.delete(id));
    }

    @PutMapping("/order")
    public ResponseEntity<?> updateOrderBatch(@RequestBody List<TbProcFunctionMap> list) {
        int result = procFunctionMapService.updateOrderBatch(list);
        return ApiUtil.success(result); // 성공 건수 반환
    }
}
