package com.job.modules.Login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.common.domain.Login.UserDetailsImpl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.common.exception.SystemException;
import com.job.common.utils.EncodeUtils;
import com.job.common.utils.JwtUtils;
import com.job.entities.Amount;
import com.job.entities.Company;
import com.job.entities.Resume;
import com.job.entities.Student;
import com.job.mapper.*;
import com.job.modules.Login.dto.CompanyRegister;
import com.job.modules.Login.dto.StudentRegister;
import com.job.modules.Login.service.LoginService;
import com.job.modules.Login.vo.MenuItemVo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
     private AmountMapper amountMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public HashMap<String, Object> login(Amount amount) {
        // 利用AuthenticationManager进行用户认证（下面👇这一行就是 UserDetailsServiceImpl 的返回，返回一个UserDetails对象，再将其给authenticationManager来验证是否通过）
        UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(amount.getUsername(), amount.getPassword());
        Authentication authenticate = authenticationManager.authenticate(passwordAuthenticationToken);
        if (Objects.isNull(authenticate)) {   // 如果为空表示验证未通过
            throw new BusinessException(Code.BUSINESS_ERR, "登陆失败，认证未通过...");
        }
        // 如果通过认证，就jwt生成token并返回
        UserDetailsImpl principal = (UserDetailsImpl) authenticate.getPrincipal(); // 含有用户信息，用户角色等的认证信息
        // 账户信息
        Amount loginUser = principal.getAmount();
        String jwt;
        try {
            // 向token中存入哪些信息(UserDetailsImpl类型的信息)
            HashMap<String,String> tokenInfo = new HashMap<>();
            tokenInfo.put("userId",principal.getAmount().getAmountId().toString());
            tokenInfo.put("role",principal.getAmount().getRoleId().toString());
            // 将tokenInfo转成json字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String tokenJson = objectMapper.writeValueAsString(tokenInfo);
            // 将json信息生成jwt
            jwt = JwtUtils.createJWT(tokenJson);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, "生成TOKEN失败，请稍后再试");
        }

        // 根据用户的roleId获取角色信息
        List<MenuItemVo> topMenuList = menuMapper.getTopMenuList(loginUser.getRoleId());

        // 将信息塞入响应体
        HashMap<String, Object> res = new HashMap<>();
        res.put("token",jwt);
        res.put("menuInfo",topMenuList);
        loginUser.setPassword("");
        res.put("userInfo",loginUser);
        return res;
    }


    /**
     * 新增用户时判断用户是否已经存在
     * @param username
     * @return false:不存在，true:已存在
     */
    public Boolean checkAmountAvailable(String username){
        LambdaQueryWrapper<Amount> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Amount::getUsername,username);
        Amount already = amountMapper.selectOne(queryWrapper);
        if(already == null){
            return false;
        }
        return true;
    }
    public Boolean checkStudentAvailable(Integer studentId){
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getStudentId,studentId);
        Student already = studentMapper.selectOne(queryWrapper);
        if(already == null){
            return false;
        }
        return true;
    }
    public Boolean checkCompanyAvailable(Integer companyId){
        LambdaQueryWrapper<Company> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Company::getCompanyId,companyId);
        Company already = companyMapper.selectOne(queryWrapper);
        if(already == null){
            return false;
        }
        return true;
    }

    /**
     * 用户注册，学生用户的处理逻辑
     * @param stuInfo
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public Result studentRegister(StudentRegister stuInfo) throws InvocationTargetException, IllegalAccessException {
//        判断用户是否存在
        if(checkAmountAvailable(stuInfo.getUsername())){
            throw new BusinessException(Code.BUSINESS_ERR,"用户已存在，请输入新账号");
        }
        if(checkStudentAvailable(stuInfo.getStudentId())){
            throw new BusinessException(Code.BUSINESS_ERR,"学号已存在，请联系管理员");
        }

//        插入新账号
        Amount amount = new Amount();
        BeanUtils.copyProperties(amount,stuInfo);
        amount.setPassword(EncodeUtils.encode(stuInfo.getPassword()));
        amountMapper.insert(amount);
//        插入新简历
        Resume resume = new Resume();
        resume.setResumerId(amount.getAmountId());
        resume.setName(stuInfo.getName());
        resumeMapper.insert(resume);
//        插入新学生信息
        Student student = new Student();
        BeanUtils.copyProperties(student,stuInfo);
        student.setResumerId(resume.getResumerId());
        student.setAmountId(amount.getAmountId());
        studentMapper.insert(student);

        return new Result(true);

        /*
        Amount amount = new Amount();
        amount.setRoleId(1);
        amount.setUsername(stuInfo.getUsername());
        amount.setPassword(stuInfo.getPassword());
        amountMapper.insert(amount);

        Resume resume = new Resume();
        resume.setResumerId(amount.getAmountId());
        resume.setName(stuInfo.getName());
        resumeMapper.insert(resume);

        Student student = new Student();
        student.setStudentId(Integer.valueOf(stuInfo.getStudentId()));
        student.setAmountId(amount.getAmountId());
        student.setMajorId(stuInfo.getMajorId());
        student.setResumerId(resume.getResumerId());
        student.setName(stuInfo.getName());
        student.setGender(stuInfo.getGender());
        if(stuInfo.getAvatar() != null){
            student.setAvatar(stuInfo.getAvatar());
        }
        student.setContact(stuInfo.getContact());
        if(stuInfo.getAddress() != null){
            student.setAddress(stuInfo.getAddress());
        }
        if(stuInfo.getBirthday() != null){
            student.setBirthday(stuInfo.getBirthday());
        }
        studentMapper.insert(student);

        return new Result(true);
         */
    }

    /**
     * 用户注册，企业用户的处理逻辑
     * @param compInfo
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public Result companyRegister(CompanyRegister compInfo) throws InvocationTargetException, IllegalAccessException {
        //        判断用户是否存在
        if(checkAmountAvailable(compInfo.getUsername())){
            throw new BusinessException(Code.BUSINESS_ERR,"用户已存在，请输入新账号");
        }
        if(checkCompanyAvailable(compInfo.getCode())){
            throw new BusinessException(Code.BUSINESS_ERR,"社会信用代码已存在，请联系管理员");
        }
        
//        插入新账户
        Amount amount = new Amount();
        BeanUtils.copyProperties(amount,compInfo);
        amount.setPassword(EncodeUtils.encode(compInfo.getPassword()));
        amountMapper.insert(amount);
//        插入新公司
        Company company = new Company();
        BeanUtils.copyProperties(company,compInfo);
        company.setAmountId(amount.getAmountId());
        companyMapper.insert(company);

        return new Result(true);
    }
}
