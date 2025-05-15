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
public class TbCommonCode {
    private Long codeSeq;      // CODE_SEQ
    private String codeGroup;  // CODE_GROUP
    private String codeId;     // CODE_ID
    private String codeName;   // CODE_NAME
    private Long parentSeq;    // PARENT_SEQ
    private Integer sortOrder; // SORT_ORDER
    private String delYn;      // DEL_YN
    private String regId;      // REG_ID
    private Date regDt;        // REG_DT
    private String modId;      // MOD_ID
    private Date modDt;        // MOD_DT
}
