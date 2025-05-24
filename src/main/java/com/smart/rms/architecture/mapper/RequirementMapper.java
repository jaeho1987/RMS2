package com.smart.rms.architecture.mapper;

import com.smart.rms.architecture.model.TbRequirement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RequirementMapper {
    List<TbRequirement> findByCondition(TbRequirement cond);
    TbRequirement findById(@Param("reqSeq") Long reqSeq);
    int insert(TbRequirement requirement);
    int update(TbRequirement requirement);
    int deleteById(@Param("reqSeq") Long reqSeq);
    int updateOrderOne(TbRequirement requirement);
    List<Map<String, Object>> findFlatRequirementList(@Param("bizSeq") Long bizSeq);

}
