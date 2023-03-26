package com.job.modules.Job.service;

import com.job.common.domain.Result;
import com.job.entities.Job;
import com.baomidou.mybatisplus.extension.service.IService;
import com.job.modules.Job.dto.JobListDto;

/**
 * @author cjf
 * @description 针对表【job】的数据库操作Service
 * @createDate 2023-02-26 23:04:30
 */
public interface JobService extends IService<Job> {
    // 获取岗位列表
    Result selectJobList(JobListDto jobListDto);

    // 新增岗位
    Result insertJob(Job job);

    // 删除岗位
    Result deleteJob(Job job);

    // 删除岗位
    Result updateJob(Job job);

}