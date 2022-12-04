package com.job.modules.Login.service.impl;

import com.job.modules.Login.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Boolean login(String username, String password) {
        return true;
    }
}
