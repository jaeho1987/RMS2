package com.smart.rms.system.mapper;

import com.smart.rms.system.model.TbCompany;
import java.util.List;

public interface CompanyMapper {
    List<TbCompany> findAll();
    TbCompany findById(Long companySeq);
    void save(TbCompany company);        // insert
    void update(TbCompany company);      // update
    void deleteById(Long companySeq);    // delete (logic)
}
