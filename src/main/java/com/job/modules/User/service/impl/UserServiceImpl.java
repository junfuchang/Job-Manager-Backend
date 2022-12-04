package com.job.modules.User.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.job.entities.User;
import com.job.mapper.UserMapper;
import com.job.modules.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper user;

    @Override
    public Boolean save(User user) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public Boolean deleteBatch(List<Integer> idList) {
        return null;
    }

    @Override
    public Boolean update(User user) {
        return null;
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public IPage<User> getAll() {
        IPage<User> userIPage = new Page<>(1,3);
        user.selectPage(userIPage,null);
        return userIPage;
    }
}
