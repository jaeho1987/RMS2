package com.smart.rms.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    private static final String ALREADY_LOGGED_ATTRIBUTE = "requestLogged";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // 중복 로깅 방지
        if (request.getAttribute(ALREADY_LOGGED_ATTRIBUTE) == null) {
            request.setAttribute(ALREADY_LOGGED_ATTRIBUTE, Boolean.TRUE);

            // 중복 래핑 방지
            ContentCachingRequestWrapper reqWrapper =
                    (request instanceof ContentCachingRequestWrapper)
                            ? (ContentCachingRequestWrapper) request
                            : new ContentCachingRequestWrapper(request);

            ContentCachingResponseWrapper resWrapper =
                    (response instanceof ContentCachingResponseWrapper)
                            ? (ContentCachingResponseWrapper) response
                            : new ContentCachingResponseWrapper(response);

            try {
                logRequest(reqWrapper);
                filterChain.doFilter(reqWrapper, resWrapper);
            } finally {
                resWrapper.copyBodyToResponse(); // 응답 본문 복사
            }
        } else {
            filterChain.doFilter(request, response); // 이미 로깅된 경우는 그대로 처리
        }
    }

    private void logRequest(ContentCachingRequestWrapper request) {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();

        String body = "";
        byte[] buf = request.getContentAsByteArray();
        if (buf.length > 0) {
            body = new String(buf, StandardCharsets.UTF_8);
        }

        log.debug("\n===== 📥 Request Log Start =====\n" +
                        "▶ Method: {}\n" +
                        "▶ URI: {}{}\n" +
                        "▶ Body: {}\n" +
                        "===== 📥 Request Log End =====",
                method,
                uri,
                (queryString != null ? "?" + queryString : ""),
                body);
    }
}
