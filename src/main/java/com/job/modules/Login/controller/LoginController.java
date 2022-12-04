package com.job.modules.Login.controller;

import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.common.domain.Result;
import com.job.entities.User;
import com.job.modules.Login.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImpl loginService;

    @PostMapping(value = {"", "/"})
    public Result login(@RequestBody User user){
        return new Result(loginService.login(user));
    }
}
