package com.smart.rms.system.controller;

import com.smart.rms.system.model.TbUser;
import com.smart.rms.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/system/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<TbUser> getAll() {
        List<TbUser> list = userService.findAll();
        String a = "a";
        return list;
    }

    @GetMapping("/getType")
    public Map getType() {
        HashMap map = new HashMap<>();
        map.put("type","호출");
        return map;
    }

    @GetMapping("/{userId}")
    public TbUser getById(@PathVariable String userId) {
        return userService.findById(userId);
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody TbUser user) {
        userService.save(user);
        return Map.of("userId", user.getUserId(), "message", "등록 완료");
    }

    @PutMapping("/{userId}")
    public void update(@PathVariable String userId, @RequestBody TbUser user) {
        user.setUserId(userId);
        userService.update(user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable String userId) {
        userService.deleteById(userId);
    }
}
