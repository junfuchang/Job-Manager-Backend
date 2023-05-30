package com.job.modules.Common.controller;

import com.job.common.domain.Result;
import com.job.modules.Common.dto.OverviewDto;
import com.job.modules.Common.service.VisualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/overview")
public class VisualController {
    @Autowired
    VisualService visualService;

    @PostMapping("/info")
    public Result getOverviewInfo(){
        return visualService.getOverviewInfo();
    }

    @PostMapping("/map")
    public Result getOverviewMap(@RequestBody OverviewDto overviewDto){
        return visualService.getOverviewMap(overviewDto);
    }

    @PostMapping("/rateByYear")
    public  Result getOverviewDetailRateByYear(){
        return visualService.getOverviewDetailRateByYear();
    }

    @PostMapping("/detailNum")
    public Result getOverviewDetailNum(){
        return visualService.getOverviewDetailNum();
    }
}
