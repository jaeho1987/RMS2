package com.smart.rms.architecture.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TbProcFunctionMap {
    private Long procFncSeq;
    private String procName;
    private String funcId;
    private String funcName;
    private String callPath;
    private String inputParams;
    private String outputColumns;
    private String dbTables;
    private String funcSummary;
    private String bizRules;
    private String tobeController;
    private String tobeService;
    private String tobeRepository;
    private String status;
    private String remarks;
    private String regId;
    private Date regDt;
    private String modId;
    private Date modDt;
    private String delYn;
}
