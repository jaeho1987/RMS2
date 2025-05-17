package com.smart.rms.system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TbUsers {
    private String userId;
    private String userName;
    private String email;
    private String password;
    private String role;
    private Long companySeq;
    private String delYn;
    private String regId;
    private Date regDt;
    private String modId;
    private Date modDt;
}
