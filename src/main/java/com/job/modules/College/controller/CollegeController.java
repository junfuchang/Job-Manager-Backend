package com.job.modules.College.controller;

import com.job.common.domain.Result;
import com.job.modules.College.dto.CollegeDto;
import com.job.modules.College.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @PostMapping("/selectCollegeList")
    public Result selectCollegeList(){
        return collegeService.selectCollegeList();
    }

    @PostMapping("/updateCollege")
    public Result updateCollege(@RequestBody CollegeDto collegeDto){
        return collegeService.updateCollege(collegeDto);
    }

    @PostMapping("/insertCollege")
    public Result insertCollege(@RequestBody CollegeDto collegeDto){
        return collegeService.insertCollege(collegeDto);
    }

    @PostMapping("/deleteCollegeById")
    public Result deleteCollege(@RequestBody CollegeDto collegeDto){
        return collegeService.deleteCollege(collegeDto);
    }
}
