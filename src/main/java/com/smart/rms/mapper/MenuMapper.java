package com.smart.rms.mapper;

import com.smart.rms.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> selectAllMenus();
}
