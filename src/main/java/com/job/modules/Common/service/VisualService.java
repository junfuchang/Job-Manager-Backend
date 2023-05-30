package com.job.modules.Common.service;

import com.job.common.domain.Result;
import com.job.modules.Common.dto.OverviewDto;

public interface VisualService {
    Result getOverviewInfo();
    Result getOverviewMap(OverviewDto overviewDto);
    Result getOverviewDetailRateByYear();
    Result getOverviewDetailNum();
}
