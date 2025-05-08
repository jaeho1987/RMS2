package com.smart.rms.system.service;

import com.smart.rms.system.mapper.UserMapper;
import com.smart.rms.system.model.TbUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    // 모든 사용자 조회
    public List<TbUser> findAll() {
        return userMapper.findAll();
    }

    // ID로 사용자 조회
    public TbUser findById(String userId) {
        return userMapper.findById(userId);
    }

    // 사용자 등록
    public void save(TbUser user) {
        userMapper.save(user); // userId 자동으로 set되는 경우 처리
    }

    // 사용자 수정
    public void update(TbUser user) {
        userMapper.update(user);
    }

    // 사용자 삭제
    public void deleteById(String userId) {
        userMapper.deleteById(userId);
    }
}
