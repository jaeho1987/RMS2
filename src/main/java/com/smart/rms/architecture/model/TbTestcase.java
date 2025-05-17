package com.smart.rms.architecture.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbTestcase {
    private Long testSeq;
    private Long reqSeq;
    private String testId;
    private String testName;
    private String testDesc;
    private String inputData;
    private String expectedResult;
    private String actualResult;
    private String testStatus;
    private Long orderNo;
    private String regId;
    private Date regDt;
    private String modId;
    private Date modDt;
    private String delYn;

    // 생성용 sysCode (ID 자동 생성 시 사용)
    private String sysCode;
}
