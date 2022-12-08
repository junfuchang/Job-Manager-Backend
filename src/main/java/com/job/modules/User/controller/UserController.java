package com.job.modules.User.controller;

import com.job.common.domain.Result;
import com.job.entities.User;
import com.job.mapper.UserMapper;
import com.job.modules.User.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "用户接口",value = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/save")
    public int addOne(){
        User aUser = new User();
        aUser.setRole(2);
        aUser.setUsername("新增用户测试");
        aUser.setPassword("123456");
        aUser.setMajorId(1);
        aUser.setAdmissionTime(new Date("2002-12-23 23:23:23"));
        int success =  userMapper.insert(aUser);
        return success;
    }

    @PostMapping("/deleteById")
    public Integer deleteOne(Integer id){
         Integer result =  userMapper.deleteById(id);
         return result;
    }

    @PostMapping("/deleteBatch")
    public Integer deleteBatch(List<Integer> idList){
        Integer result =  userMapper.deleteBatchIds(idList);
        return result;
    }

    @PostMapping("/update")
    public String updateOne(){
        return "update";
    }

    @ApiOperation("根据ID查询用户")
    @ApiImplicitParams(@ApiImplicitParam(name = "id",dataType = "Integer",required = true,value = "传入用户ID"))
    @PostMapping("/getById")
    public Result getOne(@RequestBody Integer id){
        return new Result(userService.getUserById(id));
    }

    @ApiOperation("获取全部用户")
    @PostMapping("/getUserAll")
    public Result getAll(){
        return new Result(userService.getUserAll());
    }
}
