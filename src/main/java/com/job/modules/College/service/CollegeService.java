package com.job.modules.College.service;

import com.job.common.domain.Result;
import com.job.entities.College;
import com.baomidou.mybatisplus.extension.service.IService;
import com.job.modules.College.dto.CollegeDto;

/**
* @author cjf
* @description 针对表【college(学院表)】的数据库操作Service
* @createDate 2023-02-26 23:04:24
*/
public interface CollegeService extends IService<College> {
    Result selectCollegeList();
    Result updateCollege(CollegeDto collegeDto);
    Result insertCollege(CollegeDto collegeDto);
    Result deleteCollege(CollegeDto collegeDto);

    // 获取各学院升学情况
    Result selectRateData();
}
