package com.job.modules.User.controller;

import com.job.common.domain.Result;
import com.job.common.utils.DateUtils;
import com.job.entities.User;
import com.job.mapper.UserMapper;
import com.job.modules.User.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "用户接口",value = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/save")
    public Result addOne(@RequestBody HashMap<String,String> formData) {
        User aUser = new User();
//        密码加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(formData.get("password"));
        aUser.setPassword(encodedPassword);

        aUser.setMajorId(Integer.valueOf(formData.get("majorId")));
        aUser.setRole(Integer.valueOf(formData.get("role")));
        aUser.setStudentNum(formData.get("studentNum"));
        aUser.setUsername(formData.get("username"));
        aUser.setAdmissionTime(DateUtils.getDateTime(formData.get("admissionTime")));
        aUser.setCreateTime(new Date());

        return new Result(userService.saveUser(aUser));
    }

    @PostMapping("/deleteById")
    public Result deleteById(@RequestBody HashMap Body){
        return new Result(userService.deleteUserById((Integer) Body.get("id")));
    }

    @PostMapping("/deleteBatch")
    public Integer deleteBatch(List<Integer> idList){
        Integer result =  userMapper.deleteBatchIds(idList);
        return result;
    }

    @PostMapping("/update")
    public Result updateUser(@RequestBody User Body){
        return new Result(userService.updateUser(Body));
    }

//    @ApiOperation("根据ID查询用户")
//    @ApiImplicitParams(@ApiImplicitParam(name = "id",dataType = "Integer",required = true,value = "传入用户ID"))
//    @PostMapping("/getById")
//    public Result getOne(@RequestBody Integer id){
//        return new Result(userService.getUserById(id));
//    }

    @ApiOperation("获取全部用户")
    @PostMapping("/getUserBySearch")
    @PostAuthorize("@role.isAllow('ADMIN')")
    public Result getUserBySearch(@RequestBody HashMap data){
//        System.out.println("hash:  "+data);
        return new Result(userService.getUserBySearch(data));
    }
}
