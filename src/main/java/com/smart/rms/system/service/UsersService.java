package com.smart.rms.system.service;

import com.smart.rms.system.model.TbUsers;
import com.smart.rms.system.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersMapper usersMapper;

    public List<TbUsers> findByKeyword(TbUsers users) {
        return usersMapper.findByKeyword(users);
    }

    public TbUsers findById(String userId) {
        return usersMapper.findById(userId);
    }

    public TbUsers insert(TbUsers users) {
        users.setPassword("1234");
        usersMapper.insert(users);
        return  usersMapper.findById(users.getUserId());
    }

    public int update( TbUsers users) {
        return usersMapper.update(users);
    }

    public int  delete(String userId) {
        return usersMapper.deleteById(userId);
    }

    public int updateOrderBatch(List<TbUsers> list) {
        if (list == null || list.isEmpty()) return 0;
        int count = 0;
        for (TbUsers item : list) {
            count += usersMapper.updateOrderOne(item);
        }
        return count;
    }
}
