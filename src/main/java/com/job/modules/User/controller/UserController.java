package com.job.modules.User.controller;

import com.job.common.result.Result;
import com.job.entities.User;
import com.job.mapper.UserMapper;
import com.job.modules.User.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;

//  --- 增 ---

    @PostMapping("/add")
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

//  --- 删 ---

    @PostMapping("/delete")
    public Integer deleteOne(Integer id){
         Integer result =  userMapper.deleteById(id);
         return result;
    }

    @PostMapping("/deleteBatch")
    public Integer deleteBatch(List<Integer> idList){
        Integer result =  userMapper.deleteBatchIds(idList);
        return result;
    }

//  --- 改 ---

    @PostMapping("/update")
    public String updateOne(){
        return "update";
    }

//  --- 查 ---

    @PostMapping("/get")
    public String getOne(Integer id){
        User theUser =  userMapper.selectById(id);
        return "你好"+theUser;
    }

    @PostMapping("getAll")
    public Result getAll(){
        return new Result(userService.getAll());
    }
}
