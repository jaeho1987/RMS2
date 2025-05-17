package com.smart.rms.system.controller;

import com.smart.rms.system.model.TbUsers;
import com.smart.rms.system.service.UsersService;
import com.smart.rms.util.ApiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping
    public List<TbUsers> findByKeyword(@ModelAttribute TbUsers users) {
        return usersService.findByKeyword(users);
    }

    @GetMapping("/{userId}")
    public TbUsers findById(@PathVariable String userId) {
        return usersService.findById(userId);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody TbUsers users) {
        users.setDelYn("N");
        return ApiUtil.success(usersService.insert(users));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable String userId, @RequestBody TbUsers users) {
        users.setUserId(userId);
        return ApiUtil.success(usersService.update(users));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable String userId) {
        return ApiUtil.success(usersService.delete(userId));
    }
}
