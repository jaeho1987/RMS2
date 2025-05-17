package com.smart.rms.system.service;

import com.smart.rms.system.mapper.DevGuideMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DevGuideService {

    @Autowired
    private DevGuideMapper devGuideMapper;

    // 테이블명에 해당하는 컬럼 목록과 데이터 타입을 조회하는 메서드
    public List<Map<String, String>> getColumns(String tableName) {
        return devGuideMapper.getColumns(tableName);
    }
}
