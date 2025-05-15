package com.smart.rms.system.mapper;

import com.smart.rms.system.model.TbMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<TbMenu> selectMenusByUserId(@Param("userId") String userId);

    TbMenu findById(@Param("menuSeq") Long menuSeq);

    int insert(TbMenu tbMenu);

    int update(TbMenu tbMenu);

    int deleteById(@Param("menuSeq") Long menuSeq, @Param("modId") String modId);

    int updateMenuOrder(@Param("menuSeq") Long menuSeq, @Param("menuOrder") Integer menuOrder, @Param("modId") String modId);
}
