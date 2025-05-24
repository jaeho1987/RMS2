package com.smart.rms.system.controller;

import com.smart.rms.system.model.LoginRequest;
import com.smart.rms.system.model.TbUsers;
import com.smart.rms.system.service.UsersService;
import com.smart.rms.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @GetMapping("/me")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal User user) {
        if (user == null) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(user.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        log.debug("🔐 전달된 로그인 요청: userId={}, password={}", loginRequest.getUserId(), loginRequest.getPassword());

        TbUsers user = usersService.findById(loginRequest.getUserId());
        if (user == null) {
            log.warn("❌ 사용자 없음");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("사용자 없음");
        }

        log.warn("입력값 1234 → 인코딩 후 = {}", passwordEncoder.encode("1234"));
        log.warn("비교 결과 = {}", passwordEncoder.matches("1234", user.getPassword()));


        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            log.warn("❌ 비밀번호 불일치");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비밀번호 오류");
        }

        log.debug("✅ 로그인 성공");

        String accessToken = jwtUtil.generateAccessToken(String.valueOf(user.getUserId()), user.getRole());
        String refreshToken = jwtUtil.generateRefreshToken(String.valueOf(user.getUserId()));

        ResponseCookie refreshCookie = ResponseCookie.from("refresh_token", refreshToken)
                .httpOnly(true)
                .secure(true)
                .path("/api")
                .maxAge(7 * 24 * 60 * 60)
                .sameSite("Strict")
                .build();

        response.addHeader("Set-Cookie", refreshCookie.toString());

        Map<String, Object> result = new HashMap<>();
        result.put("accessToken", accessToken);
        result.put("userId", user.getUserId());
        result.put("role", user.getRole());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/refresh")
    public ResponseEntity<?> refreshAccessToken(@CookieValue(value = "refresh_token", required = false) String refreshToken) {
        if (refreshToken == null || !jwtUtil.validateToken(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("유효하지 않은 리프레시 토큰입니다.");
        }

        String userId = jwtUtil.getUserIdFromToken(refreshToken);
        TbUsers user = usersService.findById(userId);
        if (user == null || !"N".equals(user.getDelYn())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("사용자를 찾을 수 없습니다.");
        }

        String newAccessToken = jwtUtil.generateAccessToken(userId, user.getRole());

        Map<String, Object> result = new HashMap<>();
        result.put("accessToken", newAccessToken);
        result.put("userId", userId);
        result.put("role", user.getRole());

        return ResponseEntity.ok(result);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        ResponseCookie deleteCookie = ResponseCookie.from("refresh_token", "")
                .httpOnly(true)
                .secure(true)
                .path("/api")
                .maxAge(0)
                .sameSite("Strict")
                .build();

        response.addHeader("Set-Cookie", deleteCookie.toString());

        return ResponseEntity.ok("로그아웃 완료");
    }
}
