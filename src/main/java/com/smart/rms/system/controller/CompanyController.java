package com.smart.rms.system.controller;

import com.smart.rms.system.model.TbCompany;
import com.smart.rms.system.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/system/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<TbCompany> getAll() {
        return companyService.findAll();
    }

    @GetMapping("/{companySeq}")
    public TbCompany getById(@PathVariable Long companySeq) {
        return companyService.findById(companySeq);
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody TbCompany company) {
        companyService.save(company);
        return Map.of("companySeq", company.getCompanySeq(), "message", "등록 완료");
    }


    @PutMapping("/{companySeq}")
    public void update(@PathVariable Long companySeq, @RequestBody TbCompany company) {
        company.setCompanySeq(companySeq);
        companyService.update(company);
    }

    @DeleteMapping("/{companySeq}")
    public void delete(@PathVariable Long companySeq) {
        companyService.deleteById(companySeq);
    }
}
