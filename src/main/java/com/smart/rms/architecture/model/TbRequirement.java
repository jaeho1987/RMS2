package com.smart.rms.architecture.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbRequirement {
    private Long reqSeq;
    private Long bizSeq; // ✅ 변경됨
    private String sysCode;   // ✅ 시스템 코드 추가
    private String reqId;
    private String reqName;
    private String reqDesc;
    private String reqTypeCode;
    private String priorityCode;
    private String statusCode;
    private Long parentSeq;

    private String ownerId;
    private Date planStartDt;
    private Date planEndDt;
    private Date actStartDt;
    private Date actEndDt;
    private Long orderNo;

    private String delYn;
    private String regId;
    private Date regDt;
    private String modId;
    private Date modDt;
}
