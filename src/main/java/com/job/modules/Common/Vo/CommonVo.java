package com.job.modules.Common.Vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class CommonVo {
    List<Object> directionList;

//    毕业生去向
    Integer directionType;
    Integer directionCount;

//    学历
    Integer degreeType;
    Integer degreeCount;

//    性别分布
    Integer genderType;
    Integer genderCount;
}
