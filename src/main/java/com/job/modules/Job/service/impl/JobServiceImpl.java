package com.job.modules.Job.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.Job;
import com.job.mapper.JobMapper;
import com.job.modules.Job.dto.JobListDto;
import com.job.modules.Job.service.JobService;
import com.job.modules.Job.vo.JobListVo;
import com.job.modules.Student.vo.StudentListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * @author cjf
 * @description 针对表【job】的数据库操作Service实现
 * @createDate 2023-02-26 23:04:30
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job>
        implements JobService {

    @Autowired
    JobMapper jobMapper;

    @Override
    public Result selectJobList(JobListDto jobListDto) {
        if(jobListDto.getCompanyId() != null){
            // throw new BusinessException(Code.BUSINESS_ERR,"无企业ID无法获取相关岗位");
            LambdaQueryWrapper<Job> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.orderByDesc(Job::getJobId);
            return new Result(jobMapper.selectPage(new Page<>(1,100),queryWrapper));
        }else{
            Integer current = jobListDto.getCurrent();
            Integer pageSize = jobListDto.getPageSize();

            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("now",new Date());

            if(jobListDto.getTitle() != null){
                hashMap.put("title",jobListDto.getTitle());
            }
            if(jobListDto.getCompanyName() != null){
                hashMap.put("name",jobListDto.getCompanyName());
            }
            if(jobListDto.getJobId() != null){
                hashMap.put("jobId",jobListDto.getJobId());
            }
            if(jobListDto.getIsOpenAndTimely() != null && jobListDto.getIsOpenAndTimely() != -1){
                hashMap.put("isOpenAndTimely",jobListDto.getIsOpenAndTimely());
            }

            Page<JobListVo> data = jobMapper.selectJobList(new Page<>(current,pageSize),hashMap);
            return new Result(data);
        }
    }

    public Result insertJob(Job job){
        if(job.getCompanyId() == null){
            throw new BusinessException(Code.BUSINESS_ERR,"新增岗位无企业ID");
        }
        jobMapper.insert(job);
        return new Result(true);
    }

    @Override
    public Result deleteJob(Job job) {
        if(job.getJobId() == null){
            throw new BusinessException(Code.BUSINESS_ERR,"删除岗位无岗位ID");
        }
        jobMapper.deleteById(job.getJobId());
        return new Result(true);
    }

    @Override
    public Result updateJob(Job job) {
        jobMapper.updateById(job);
        return new Result(true);
    }
}




