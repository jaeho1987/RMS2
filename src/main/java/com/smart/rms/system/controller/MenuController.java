package com.smart.rms.system.controller;

import com.smart.rms.system.model.TbMenu;
import com.smart.rms.system.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public List<TbMenu> getMenus(Authentication authentication) {
        return menuService.getMenusByUserId(authentication.getName());
    }

    @GetMapping("/{menuSeq}")
    public TbMenu getMenu(@PathVariable Long menuSeq) {
        return menuService.getMenuById(menuSeq);
    }

    @PostMapping
    public ResponseEntity<TbMenu> createMenu(@RequestBody TbMenu tbMenu, Authentication authentication) {
        tbMenu.setRegId(authentication.getName());
        tbMenu.setDelYn("N");
        menuService.createMenu(tbMenu);
        return ResponseEntity.ok(tbMenu);
    }

    @PutMapping("/{menuSeq}")
    public ResponseEntity<Void> updateMenu(@PathVariable Long menuSeq,
                                           @RequestBody TbMenu tbMenu,
                                           Authentication authentication) {
        tbMenu.setMenuSeq(menuSeq);
        tbMenu.setModId(authentication.getName());
        menuService.updateMenu(tbMenu);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{menuSeq}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuSeq, Authentication authentication) {
        menuService.deleteMenu(menuSeq, authentication.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/order")
    public ResponseEntity<Void> updateMenuOrders(@RequestBody List<TbMenu> menus,
                                                 Authentication authentication) {
        menuService.updateMenuOrders(menus, authentication.getName());
        return ResponseEntity.ok().build();
    }
}
