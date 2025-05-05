package com.smart.rms.system.mapper;

import com.smart.rms.system.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> selectMenusByUserId(@Param("userId") String userId);
}
