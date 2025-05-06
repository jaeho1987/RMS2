package com.smart.rms.system.service;

import com.smart.rms.system.mapper.CompanyMapper;
import com.smart.rms.system.model.TbCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyMapper companyMapper;

    public List<TbCompany> findAll() {
        return companyMapper.findAll();
    }

    public TbCompany findById(Long companySeq) {
        return companyMapper.findById(companySeq);
    }

    public void save(TbCompany company) {
        companyMapper.save(company); // companySeq 자동으로 selectKey로 세팅됨
    }

    public void update(TbCompany company) {
        companyMapper.update(company);
    }

    public void deleteById(Long companySeq) {
        companyMapper.deleteById(companySeq);
    }
}
