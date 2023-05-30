package com.job.modules.JobStudent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.Job;
import com.job.entities.JobStudent;
import com.job.mapper.JobStudentMapper;
import com.job.modules.Job.vo.JobListVo;
import com.job.modules.JobStudent.dto.JobStudentDto;
import com.job.modules.JobStudent.service.JobStudentService;
import com.job.modules.JobStudent.vo.JobStudentListVo;
import com.job.modules.Student.vo.StudentListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
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
            return new Result(one);
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
        int delete = jobStudentMapper.delete(wrapper);

        return new Result(delete>=1);
    }

    @Override
    public Result selectJobStudentList(JobStudentDto jobStudentDto) {
        if(jobStudentDto.getJobId() == null && jobStudentDto.getStudentId() == null && jobStudentDto.getCompanyId() == null ){
            throw new BusinessException(Code.BUSINESS_ERR,"请传入companyId、jobId或studentId参数");
        }
        Integer current = jobStudentDto.getCurrent();
        Integer pageSize = jobStudentDto.getPageSize();

        HashMap<String, Object> hashMap = new HashMap<>();
        if(jobStudentDto.getCompanyId() != null){
            hashMap.put("companyId",jobStudentDto.getCompanyId());
        }
        if(jobStudentDto.getJobId() != null){
            hashMap.put("jobId",jobStudentDto.getJobId());
        }
        if(jobStudentDto.getStudentId() != null){
            hashMap.put("studentId",jobStudentDto.getStudentId());
        }
        if(jobStudentDto.getJobName() != null ){
            hashMap.put("jobName",jobStudentDto.getJobName());
        }
        if(jobStudentDto.getCompanyName() != null ){
            hashMap.put("companyName",jobStudentDto.getCompanyName());
        }
        if(jobStudentDto.getFeedback() != null && jobStudentDto.getFeedback() != -1){
            hashMap.put("feedback",jobStudentDto.getFeedback());
        }

        Page<JobStudentListVo> data = jobStudentMapper.selectJobStudentList(new Page<>(current,pageSize),hashMap);
        return new Result(data);
    }

    @Override
    public Result jobPass(JobStudentDto jobStudentDto) {
        if(jobStudentDto.getJobStudentId() == null){
            throw new BusinessException(Code.BUSINESS_ERR,"jobPass接口需要提供jobStudentId");
        }
        LambdaQueryWrapper<JobStudent> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(JobStudent::getJobStudentId,jobStudentDto.getJobStudentId());
        JobStudent jobStudent1 = jobStudentMapper.selectOne(queryWrapper);
        jobStudent1.setFeedback(2);
        jobStudentMapper.updateById(jobStudent1);
        return new Result(true);
    }

    @Override
    public Result jobReject(JobStudentDto jobStudentDto) {
        if(jobStudentDto.getJobStudentId() == null){
            throw new BusinessException(Code.BUSINESS_ERR,"jobPass接口需要提供jobStudentId");
        }
        LambdaQueryWrapper<JobStudent> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(JobStudent::getJobStudentId,jobStudentDto.getJobStudentId());
        JobStudent jobStudent1 = jobStudentMapper.selectOne(queryWrapper);
        jobStudent1.setFeedback(1);
        jobStudentMapper.updateById(jobStudent1);
        return new Result(true);
    }
}
