package com.smart.rms.system.model;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TbCompany {
    private Long companySeq;
    private String companyName;
    private String bizNo;
    private String bizType;
    private String bizCondition;
    private String telNo;
    private String email;
    private String zipCode;
    private String address;
    private String description;

    private String delYn;
    private String regId;
    private Date regDt;
    private String modId;
    private Date modDt;
}
