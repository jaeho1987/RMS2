package com.smart.rms.architecture.service;


import com.smart.rms.architecture.mapper.RequirementMapper;
import com.smart.rms.architecture.model.TbRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequirementService {

    private final RequirementMapper mapper;

    // 조건 조회 (예: 시스템별)
    public List<TbRequirement> findByCondition(TbRequirement cond) {
        return mapper.findByCondition(cond);
    }

    // 단건 조회
    public TbRequirement findById(Long reqSeq) {
        return mapper.findById(reqSeq);
    }

    // 등록
    public TbRequirement insert(TbRequirement req) {
        mapper.insert(req);
        log.info("TbRequirement : " + req);
        return mapper.findById(req.getReqSeq());  // ✅ INSERT 후 다시 조회해서 리턴
    }

    // 수정
    public int update(TbRequirement req) {
        return mapper.update(req);
    }

    // 삭제 (논리삭제)
    public int deleteById(Long reqSeq) {
        return mapper.deleteById(reqSeq);
    }

    // 정렬 순서 일괄 저장
    public int updateOrderBatch(List<TbRequirement> list) {
        if (list == null || list.isEmpty()) return 0;
        int count = 0;
        for (TbRequirement item : list) {
            count += mapper.updateOrderOne(item);
        }
        return count;
    }

    public List<Map<String, Object>> findFlatRequirementList(Long bizSeq) {
        return mapper.findFlatRequirementList(bizSeq);
    }

}