package com.smart.rms.architecture.service;

import com.smart.rms.architecture.mapper.TestcaseMapper;
import com.smart.rms.architecture.model.TbTestcase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestcaseService {

    private final TestcaseMapper testcaseMapper;

    public List<TbTestcase> findAll(TbTestcase testcase) {
        return testcaseMapper.findAll(testcase);
    }

    public TbTestcase findById(Long testSeq) {
        return testcaseMapper.findById(testSeq);
    }

    public List<TbTestcase> findByReqSeq(Long reqSeq) {
        return testcaseMapper.findByReqSeq(reqSeq);
    }

    public TbTestcase insert(TbTestcase testcase) {
        testcaseMapper.insert(testcase);
        return testcaseMapper.findById(testcase.getTestSeq());
    }

    public int update(TbTestcase testcase) {
        return testcaseMapper.update(testcase);
    }

    public int deleteById(Long testSeq) {
        return testcaseMapper.deleteById(testSeq);
    }

    public int updateOrderBatch(List<TbTestcase> list) {
        if (list == null || list.isEmpty()) return 0;
        int count = 0;
        for (TbTestcase item : list) {
            count += testcaseMapper.updateOrderOne(item);
        }
        return count;
    }

}
