package com.smart.rms.system.controller;

import com.smart.rms.system.model.TbMenu;
import com.smart.rms.system.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public List<TbMenu> getMenus(Authentication authentication) {
        String userId = authentication.getName(); // Spring Security에서 로그인된 사용자 ID
        return menuService.getMenusByUserId(userId);
    }
}