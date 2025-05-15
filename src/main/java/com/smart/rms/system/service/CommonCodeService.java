package com.smart.rms.system.service;

import com.smart.rms.system.mapper.CommonCodeMapper;
import com.smart.rms.system.model.TbCommonCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommonCodeService {

    private final CommonCodeMapper mapper;

    public List<TbCommonCode> findByKeyword(TbCommonCode code) {
        return mapper.findByKeyword(code);
    }

    public TbCommonCode findById(Long codeSeq) {
        return mapper.findById(codeSeq);
    }

    public int insert(TbCommonCode code) {
        return mapper.insert(code);
    }

    public int update(TbCommonCode code) {
        return mapper.update(code);
    }

    public int deleteById(Long codeSeq) {
        return mapper.deleteById(codeSeq);
    }

    // 정렬 순서 일괄 저장
    public int updateOrderBatch(List<TbCommonCode> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (TbCommonCode item : list) {
            // 한 행씩 updateOrderOne() 실행
            count += mapper.updateOrderOne(item);
        }
        return count;
    }

    public Map<String, List<TbCommonCode>> getAllGrouped() {
        List<TbCommonCode> list = mapper.findAllActive();
        return list.stream()
                .collect(Collectors.groupingBy(TbCommonCode::getCodeGroup, LinkedHashMap::new, Collectors.toList()));
    }

}
