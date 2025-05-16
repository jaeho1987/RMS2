package com.smart.rms.system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TbUser {

    private String userId;          // 사용자 ID (시퀀스 기반)
    private String userName;      // 사용자 이름
    private String email;         // 이메일
    private String password;      // 비밀번호 (해시 저장)
    private String role;          // 권한 (예: USER, ADMIN)
    private Long companySeq;      // 소속 회사 SEQ
    private String delYn;         // 삭제 여부 (Y/N)
    private String regId;         // 등록자
    private LocalDateTime regDt;  // 등록일시
    private String modId;         // 수정자
    private LocalDateTime modDt;  // 수정일시
}
