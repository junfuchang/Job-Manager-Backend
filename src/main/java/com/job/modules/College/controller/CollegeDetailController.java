package com.job.modules.College.controller;

import com.job.common.domain.Result;
import com.job.modules.College.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collegeDetail")
public class CollegeDetailController {

    @Autowired
    CollegeService collegeService;

    @PostMapping("/selectRateData")
    public Result selectRateData(){
        return collegeService.selectRateData();
    }

}
