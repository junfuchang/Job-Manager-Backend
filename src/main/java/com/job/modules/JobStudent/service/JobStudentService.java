package com.job.modules.JobStudent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.job.common.domain.Result;
import com.job.entities.JobStudent;
import com.job.modules.JobStudent.dto.JobStudentDto;

public interface JobStudentService extends IService<JobStudent> {

    Result alreadySubmitJob(JobStudentDto jobStudentDto);
    Result submitJob(JobStudentDto jobStudentDto);
    Result cancelJob(JobStudentDto jobStudentDto);
    Result selectJobStudentList(JobStudentDto jobStudentDto);
    Result jobPass(JobStudentDto jobStudentDto);
    Result jobReject(JobStudentDto jobStudentDto);


}
