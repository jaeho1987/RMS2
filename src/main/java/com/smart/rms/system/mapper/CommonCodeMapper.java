package com.smart.rms.system.mapper;

import com.smart.rms.system.model.TbCommonCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonCodeMapper {

    List<TbCommonCode> findByKeyword(TbCommonCode code);
    TbCommonCode findById(@Param("codeSeq") Long codeSeq);
    int insert(TbCommonCode code);
    int update(TbCommonCode code);
    int deleteById(@Param("codeSeq") Long codeSeq);
    int updateOrderOne(TbCommonCode code);
    List<TbCommonCode> findAllActive();

}
