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
public class TbFileInfo {
    private Long fileSeq;
    private Long refSeq;
    private String fileType;
    private String fileName;
    private String originalName;
    private String filePath;
    private String fileExt;
    private Long fileSize;
    private String delYn;
    private String regId;
    private Date regDt;
    private String modId;
    private Date modDt;
}