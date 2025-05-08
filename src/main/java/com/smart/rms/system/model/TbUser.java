package com.smart.rms.system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TbUser {

    private String userId;        // 사용자 ID
    private String userName;      // 사용자 이름
    private String telNo;         // 전화번호
    private String address;       // 주소
    private String email;         // 이메일
}
