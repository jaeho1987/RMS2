package com.smart.rms.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface DevGuideMapper {

    // 주어진 테이블에 대한 컬럼 목록 조회
    List<Map<String,String>> getColumns(String tableName);
}
