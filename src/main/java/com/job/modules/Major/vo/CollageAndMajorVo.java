package com.job.modules.Major.vo;

import lombok.Data;

import java.util.List;

@Data
public class CollageAndMajorVo {
    /**
     * collageId
     */
    private Integer value;
    /**
     * collageName
     */
    private String label;
    List<MajorVo> children;
}
