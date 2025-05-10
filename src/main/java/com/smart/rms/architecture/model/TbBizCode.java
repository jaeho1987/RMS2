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
    private String delYn;
    private String regId;
    private String modId;
    private String regDt;
    private String modDt;
}
