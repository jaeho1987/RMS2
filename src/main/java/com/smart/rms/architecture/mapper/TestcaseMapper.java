package com.smart.rms.architecture.mapper;

import com.smart.rms.architecture.model.TbTestcase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestcaseMapper {
    List<TbTestcase> findAll(TbTestcase testcase);
    TbTestcase findById(Long testSeq);
    List<TbTestcase> findByReqSeq(Long reqSeq);
    void insert(TbTestcase testcase);
    int update(TbTestcase testcase);
    int deleteById(Long testSeq);
    int updateOrderOne(TbTestcase testcase);

}
