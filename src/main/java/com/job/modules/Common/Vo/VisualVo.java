package com.job.modules.Common.Vo;

import lombok.Data;

import java.util.List;

@Data
public class VisualVo {
    List<CommonVo> direction;
    List<CommonVo> degree;
    SalaryVo salary;
}
