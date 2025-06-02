package com.smart.rms.architecture.mapper;

import com.smart.rms.architecture.model.TbProcFunctionMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProcFunctionMapMapper {

    List<TbProcFunctionMap> findByKeyword(TbProcFunctionMap procFunctionMap);
    TbProcFunctionMap findById(@Param("id") Long id);
    int insert(TbProcFunctionMap procFunctionMap);
    int update(TbProcFunctionMap procFunctionMap);
    int deleteById(@Param("id") Long id);
    int updateOrderOne(TbProcFunctionMap procFunctionMap);
}
