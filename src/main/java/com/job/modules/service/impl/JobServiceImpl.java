package com.job.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.Job;
import com.job.modules.service.JobService;
import com.job.mapper.JobMapper;
import org.springframework.stereotype.Service;

/**
* @author cjf
* @description 针对表【job】的数据库操作Service实现
* @createDate 2023-02-26 23:04:30
*/
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job>
    implements JobService {

}




