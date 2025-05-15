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

    public TbMenu getMenuById(Long menuSeq) {
        return menuMapper.findById(menuSeq);
    }

    public int createMenu(TbMenu tbMenu) {
        return menuMapper.insert(tbMenu);
    }

    public int updateMenu(TbMenu tbMenu) {
        return menuMapper.update(tbMenu);
    }

    public int deleteMenu(Long menuSeq, String modId) {
        return menuMapper.deleteById(menuSeq, modId);
    }

    public void updateMenuOrders(List<TbMenu> menus, String modId) {
        for (TbMenu menu : menus) {
            menuMapper.updateMenuOrder(menu.getMenuSeq(), menu.getMenuOrder(), modId);
        }
    }
}
