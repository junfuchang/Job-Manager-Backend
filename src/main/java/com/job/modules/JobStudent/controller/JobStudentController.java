package com.job.modules.JobStudent.controller;

import com.job.common.domain.Result;
import com.job.modules.JobStudent.dto.JobStudentDto;
import com.job.modules.JobStudent.service.JobStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/job-student")
public class JobStudentController {
    @Autowired
    JobStudentService jobStudentService;

    @PostMapping("/alreadySubmitJob")
    public Result alreadySubmitJob(@RequestBody JobStudentDto jobStudentDto){
        return jobStudentService.alreadySubmitJob(jobStudentDto);
    }

    @PostMapping("/submitJob")
    public Result submitJob(@RequestBody JobStudentDto jobStudentDto){
        return jobStudentService.submitJob(jobStudentDto);
    }

    @PostMapping("/cancelJob")
    public Result cancelJob(@RequestBody JobStudentDto jobStudentDto){
        return jobStudentService.cancelJob(jobStudentDto);
    }
}
