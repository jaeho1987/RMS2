package com.smart.rms.system.service;

import com.smart.rms.system.mapper.MenuMapper;
import com.smart.rms.system.model.TbMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper menuMapper;

    public List<TbMenu> getMenusByUserId(String userId) {
        return menuMapper.selectMenusByUserId(userId);
    }
}
