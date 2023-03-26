package com.job.modules.JobStudent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.JobStudent;
import com.job.mapper.JobStudentMapper;
import com.job.modules.JobStudent.dto.JobStudentDto;
import com.job.modules.JobStudent.service.JobStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobStudentServiceImpl extends ServiceImpl<JobStudentMapper, JobStudent> implements JobStudentService {

    @Autowired
    JobStudentMapper jobStudentMapper;

    @Override
    public Result alreadySubmitJob(JobStudentDto jobStudentDto) {
        if(jobStudentDto.getJobId() == null || jobStudentDto.getStudentId() == null){
            throw new BusinessException(Code.BUSINESS_ERR,"alreadySubmitJob接口需要提供学生ID及岗位ID");
        }
        LambdaQueryWrapper<JobStudent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(JobStudent::getJobId,jobStudentDto.getJobId());
        wrapper.eq(JobStudent::getStudentId,jobStudentDto.getStudentId());
        JobStudent one = jobStudentMapper.selectOne(wrapper);
        if(one != null){
            return new Result(true);
        }
        return new Result(false);
    }

    @Override
    public Result submitJob(JobStudentDto jobStudentDto) {
        if(jobStudentDto.getJobId() == null || jobStudentDto.getStudentId() == null){
            throw new BusinessException(Code.BUSINESS_ERR,"submitJob接口需要提供学生ID及岗位ID");
        }
        JobStudent jobStudent = new JobStudent();
        jobStudent.setJobId(jobStudentDto.getJobId());
        jobStudent.setStudentId(jobStudentDto.getStudentId());
        jobStudent.setDate(new Date());
        jobStudentMapper.insert(jobStudent);
        return new Result(true);
    }

    @Override
    public Result cancelJob(JobStudentDto jobStudentDto) {
        if(jobStudentDto.getJobId() == null || jobStudentDto.getStudentId() == null){
            throw new BusinessException(Code.BUSINESS_ERR,"cancelJob接口需要提供学生ID及岗位ID");
        }
        LambdaQueryWrapper<JobStudent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(JobStudent::getJobId,jobStudentDto.getJobId());
        wrapper.eq(JobStudent::getStudentId,jobStudentDto.getStudentId());
        List<JobStudent> jobStudents = jobStudentMapper.selectList(wrapper);
        for (JobStudent jobStudent: jobStudents
             ) {
            int delete = jobStudentMapper.deleteById(jobStudent);
        }

        System.out.println("\n\n======"+ jobStudents +"=====\n\n");


        return new Result(true);
    }
}
