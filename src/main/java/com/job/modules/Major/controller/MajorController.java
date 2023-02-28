package com.job.modules.Major.controller;

import com.job.common.domain.Result;
import com.job.modules.Major.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
