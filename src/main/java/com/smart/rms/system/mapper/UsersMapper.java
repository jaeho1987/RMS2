package com.smart.rms.system.mapper;

import com.smart.rms.system.model.TbUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersMapper {

    List<TbUsers> findByKeyword(TbUsers users);
    TbUsers findById(@Param("id") String id);
    int insert(TbUsers users);
    int update(TbUsers users);
    int deleteById(@Param("id") String id);
    int updateOrderOne(TbUsers users);
}
