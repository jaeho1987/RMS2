package com.smart.rms.util;

import com.smart.rms.system.model.ApiResponse;
import org.springframework.http.ResponseEntity;

public class ApiUtil {

    // ✅ 성공 응답 (데이터만)
    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(new ApiResponse<>(true, data, null));
    }

    // ✅ 실패 응답 (메시지 포함)
    public static ResponseEntity<ApiResponse<?>> fail(String message) {
        return ResponseEntity.badRequest().body(new ApiResponse<>(false, null, message));
    }

    // (선택) 성공 응답 + 메시지 포함 버전도 만들 수 있음
    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        return ResponseEntity.ok(new ApiResponse<>(true, data, message));
    }
}
