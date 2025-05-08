package com.smart.rms.system.mapper;

import com.smart.rms.system.model.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // 모든 사용자 조회
    List<TbUser> findAll();

    // ID로 사용자 조회
    TbUser findById(String userId);

    // 사용자 등록
    void save(TbUser user);

    // 사용자 정보 수정
    void update(TbUser user);

    // 사용자 삭제
    void deleteById(String userId);
}
