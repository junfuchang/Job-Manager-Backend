package com.job.modules.Amount.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.MyPage;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.common.utils.DateUtils;
import com.job.common.utils.EncodeUtils;
import com.job.entities.*;
import com.job.mapper.*;
import com.job.modules.Amount.dto.AmountListDto;
import com.job.modules.Amount.dto.PasswordDto;
import com.job.modules.Amount.service.AmountService;
import com.job.modules.Login.service.LoginService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @author cjf
* @description 针对表【amount】的数据库操作Service实现
* @createDate 2023-02-26 23:04:21
*/
@Service
public class AmountServiceImpl extends ServiceImpl<AmountMapper, Amount>
    implements AmountService {
    @Autowired
    AmountMapper amountMapper;
    @Autowired
    LoginService loginService;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    JobMapper jobMapper;
    @Autowired
    JobStudentMapper jobStudentMapper;



    /**
     * 查询amount
     */
    @Override
    public Result selectAmountList(AmountListDto amountListDto) {
        Integer current = amountListDto.getCurrent();
        Integer pageSize = amountListDto.getPageSize();
        if(current == null || pageSize == null){
            return new Result(200,amountMapper.selectList(null),"无分页参数，返回全部数据");
        }{
            LambdaQueryWrapper<Amount> queryWrapper = new LambdaQueryWrapper<>();
            if(amountListDto.getAmountId() != null ){
                queryWrapper.eq(Amount::getAmountId,amountListDto.getAmountId());
            }
            if(amountListDto.getUsername() != null ){
                queryWrapper.like(Amount::getUsername,amountListDto.getUsername());
            }
            if(amountListDto.getRoleId() != null && amountListDto.getRoleId() != -1){
                queryWrapper.eq(Amount::getRoleId,amountListDto.getRoleId());
            }
            if(amountListDto.getCreateTime() != null ){
                Date createTime = amountListDto.getCreateTime();  //  Tue Mar 07 17:34:23 CST 2023
                queryWrapper.between(Amount::getCreateTime, DateUtils.getStartTime(createTime),DateUtils.getEndTime(createTime));
            }

            MyPage<Amount> data = amountMapper.selectPage(new MyPage<>(amountListDto.getCurrent(), pageSize), queryWrapper);

            List<Amount> amountList = new ArrayList<>();
            for (Amount amount: data.getRecords()) {
                amount.setPassword(null);
                amountList.add(amount);
            }
            data.setList(amountList);
            data.setRecords(amountList);

            return new Result(data);
        }

    }

    /**
     * 删除amount
     */
    @Override
    public Result deleteAmountById(AmountListDto amountListDto) {
        if(amountListDto.getAmountId() == null){
            throw new BusinessException(Code.BUSINESS_ERR,"删除账户需要传入账户ID");
        }
        Amount amount = amountMapper.selectById(amountListDto.getAmountId());

        System.out.println("\n\n================\n\n");
        if(amount.getRoleId() == 0){
            // 删除学生信息
            LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Student::getAmountId,amountListDto.getAmountId());
            Student student = studentMapper.selectOne(queryWrapper);
            studentMapper.deleteById(student);
        }

        if(amount.getRoleId() == 1){
            // 找出公司
            LambdaQueryWrapper<Company> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Company::getAmountId,amountListDto.getAmountId());
            Company company = companyMapper.selectOne(queryWrapper);
            // 找出公司的岗位
            LambdaQueryWrapper<Job> jobWrapper = new LambdaQueryWrapper<>();
            jobWrapper.eq(Job::getCompanyId,company.getCompanyId());
            List<Job> jobs = jobMapper.selectList(jobWrapper);
            // 删除相关岗位
            for (Job job:jobs
                 ) {
                jobMapper.deleteById(job);
                // 删除工作简历之间的关联
                LambdaQueryWrapper<JobStudent> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(JobStudent::getJobId,job.getJobId());
                List<JobStudent> jobStudents = jobStudentMapper.selectList(wrapper);
                for (JobStudent jobStudent : jobStudents
                     ) {
                    jobStudentMapper.deleteById(jobStudent);
                }
            }
            companyMapper.deleteById(company);
        }

        amountMapper.deleteById(amountListDto.getAmountId());
        return new Result();
    }

    /**
     * 更新amount
     */
    @Override
    public Result updateAmount(AmountListDto amountListDto) {
        if(amountListDto.getAmountId() != null){
            Amount amount = amountMapper.selectById(amountListDto.getAmountId());
            if(amountListDto.getUsername() != null && !amountListDto.getUsername().equals(amount.getUsername())){
                if(loginService.checkAmountAvailable(amountListDto.getUsername())){
                    throw new BusinessException(Code.BUSINESS_ERR,"账户名称已存在，请更换名称");
                }
                amount.setUsername(amountListDto.getUsername());
            }
            if(amountListDto.getPassword() != null){
                amount.setPassword(EncodeUtils.encode(amountListDto.getPassword()));
            }
            if(amountListDto.getRoleId() != null){
                amount.setRoleId(amountListDto.getRoleId());
            }
            amountMapper.updateById(amount);
            return new Result(true);
        }
        throw new BusinessException(Code.BUSINESS_ERR,"更新账户需要传入相关账户信息");
    }

    @Override
    public Result updatePassword(PasswordDto passwordDto) {
        if(passwordDto.getAmountId()==null || passwordDto.getPrePassword() == null || passwordDto.getPassword()==null){
            throw new BusinessException(Code.BUSINESS_ERR,"updatePassword修改密码缺少参数");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String preEncodedPassword = bCryptPasswordEncoder.encode(passwordDto.getPrePassword());
        String encodedPassword = bCryptPasswordEncoder.encode(passwordDto.getPassword());

        LambdaQueryWrapper<Amount> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Amount::getAmountId,passwordDto.getAmountId());
        Amount amount = amountMapper.selectOne(queryWrapper);
        if(bCryptPasswordEncoder.matches(passwordDto.getPrePassword(),amount.getPassword())){
            amount.setPassword(encodedPassword);
            amountMapper.updateById(amount);
            return new Result(true);
        }else {
            throw new BusinessException(Code.BUSINESS_ERR,"原密码不正确，请重新输入！");
        }
    }

    /**
     * 插入amount
     */
    @Override
    public Result insertAmount(AmountListDto amountListDto) throws InvocationTargetException, IllegalAccessException {
        Amount amount = new Amount();
        BeanUtils.copyProperties(amount,amountListDto);
        amount.setPassword(EncodeUtils.encode(amountListDto.getPassword()));
        amountMapper.insert(amount);
        return new Result(true);
    }
}




