package com.smart.rms.system.controller;

import com.smart.rms.system.service.DevGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DevGuideController {

    @Autowired
    private DevGuideService devGuideService;

    @GetMapping("/api/system/dev-guide/columns")
    public List<Map<String, String>> getColumns(@RequestParam String tableName) {
        return devGuideService.getColumns(tableName);
    }
}
