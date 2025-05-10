package com.smart.rms.architecture.controller;

import com.smart.rms.architecture.model.TbBizCode;
import com.smart.rms.architecture.service.BizCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping
    public int save(@RequestBody TbBizCode code) {
        return bizCodeService.save(code);
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

}
