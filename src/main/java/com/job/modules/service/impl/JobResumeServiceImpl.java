package com.job.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.JobStudent;
import com.job.modules.service.JobResumeService;
import com.job.mapper.JobStudentMapper;
import org.springframework.stereotype.Service;

/**
* @author cjf
* @description 针对表【job_resume(岗位-简历 关联表)】的数据库操作Service实现
* @createDate 2023-02-26 23:04:32
*/
@Service
public class JobResumeServiceImpl extends ServiceImpl<JobStudentMapper, JobStudent>
    implements JobResumeService {

}




