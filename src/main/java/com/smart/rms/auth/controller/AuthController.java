package com.smart.rms.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/api/me")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal User user) {
        if (user == null) {
            return ResponseEntity.status(401).build(); // 인증 안 되어 있음
        }
        return ResponseEntity.ok(user.getUsername()); // 로그인된 사용자명 반환
    }
}
