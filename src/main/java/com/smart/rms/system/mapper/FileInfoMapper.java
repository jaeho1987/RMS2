package com.smart.rms.system.mapper;

import com.smart.rms.system.model.TbFileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileInfoMapper {

    List<TbFileInfo> findByKeyword(TbFileInfo fileInfo);
    TbFileInfo findById(@Param("id") Long id);
    int insert(TbFileInfo fileInfo);
    int update(TbFileInfo fileInfo);
    int deleteById(@Param("id") Long id);
    int updateOrderOne(TbFileInfo fileInfo);
}
