package com.job.modules.Major.controller;

import com.job.common.domain.Result;
import com.job.entities.Major;
import com.job.modules.College.dto.CollegeDto;
import com.job.modules.Major.dto.MajorDto;
import com.job.modules.Major.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @PostMapping("/college-major")
    public Result getAllMajors(){
        return majorService.getMajors();
    }

    @PostMapping("/selectMajorList")
    public Result selectMajorList(@RequestBody MajorDto majorDto){
        return majorService.selectMajorList(majorDto);
    }

    @PostMapping("/updateMajor")
    public Result updateMajor(@RequestBody MajorDto majorDto){
        return majorService.updateMajor(majorDto);
    }

    @PostMapping("/insertMajor")
    public Result insertMajor(@RequestBody MajorDto majorDto){
        return majorService.insertMajor(majorDto);
    }

    @PostMapping("/deleteMajorById")
    public Result deleteMajor(@RequestBody MajorDto majorDto){
        return majorService.deleteMajor(majorDto);
    }
}
