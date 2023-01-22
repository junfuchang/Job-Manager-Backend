package com.job.modules.User.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.job.entities.User;
import com.job.mapper.UserMapper;
import com.job.modules.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean saveUser(User user) {
        if(userMapper.insert(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        if(userMapper.deleteById(id) == 1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUserBatch(List<Integer> idList) {
        return null;
    }

    @Override
    public Boolean updateUser(User user) {
        if(userMapper.updateById(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public IPage<User> getUserBySearch(HashMap data) {
        IPage<User> userIPage = new Page<>( (Integer)data.get("current"),(Integer)data.get("pageSize"));
        userMapper.selectPage(userIPage,null);
        return userIPage;
    }

//    @Override
//    public IPage<User> getUserAll() {
//        IPage<User> userIPage = new Page<>(1,3);
//        userMapper.selectPage(userIPage,null);
//        return userIPage;
//    }
}
