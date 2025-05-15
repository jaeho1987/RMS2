package com.smart.rms.architecture.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TbBizCode {
    private Long bizSeq;
    private Long parentSeq;
    private Integer levelNo;
    private String name;
    private String description;
    private Integer orderNo; // ✅ 정렬 순서 추가
    private String sysCode;
    private String delYn;
    private String regId;
    private String modId;
    private String regDt;
    private String modDt;
}
