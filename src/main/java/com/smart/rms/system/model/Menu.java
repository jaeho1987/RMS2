package com.smart.rms.system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor        // 프레임워크에서 기본 생성자 필요
@AllArgsConstructor       // 빌더나 전체 생성자 사용을 위한 보조
@Builder                  // 빌더 패턴 사용
public class Menu {
    private Long menuSeq;
    private Long parentSeq;
    private String menuName;
    private String menuPath;
    private String menuIcon;
    private Integer menuOrder;
    private String delYn;
    private String regId;
    private Date regDt;
    private String modId;
    private Date modDt;
}
