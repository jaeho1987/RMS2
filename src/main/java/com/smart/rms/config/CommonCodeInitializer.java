package com.smart.rms.config;

import com.smart.rms.system.model.TbCommonCode;
import com.smart.rms.system.service.CommonCodeService;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CommonCodeInitializer implements ApplicationRunner {

    private final CommonCodeService commonCodeService;
    private final ServletContext servletContext;

    @Override
    public void run(ApplicationArguments args) {
        Map<String, List<TbCommonCode>> codeMap = commonCodeService.getAllGrouped();
        servletContext.setAttribute("commonCode", codeMap);
        System.out.println("✅ [공통코드] 시스템 시작 시 캐싱 완료");
    }
}
