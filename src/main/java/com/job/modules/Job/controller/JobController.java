package com.job.modules.Job.controller;

import com.job.common.domain.Result;
import com.job.entities.Job;
import com.job.mapper.JobMapper;
import com.job.modules.Job.dto.JobListDto;
import com.job.modules.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobService jobService;

    @PostMapping("/selectJobList")
    public Result selectJobList(@RequestBody JobListDto jobListDto){
        return jobService.selectJobList(jobListDto);
    }

    @PostMapping("/insertJob")
    public Result insertJob(@RequestBody Job job){
        return jobService.insertJob(job);
    }

    @PostMapping("/deleteJob")
    public Result deleteJob(@RequestBody Job job){
        return jobService.deleteJob(job);
    }

    @PostMapping("/updateJob")
    public Result updateJob(@RequestBody Job job){
        return jobService.updateJob(job);
    }
}
