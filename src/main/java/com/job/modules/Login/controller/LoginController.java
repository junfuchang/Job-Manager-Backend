package com.job.modules.Login.controller;

import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.common.result.Result;
import com.job.modules.Login.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @PostMapping(value = {"", "/"})
    public Result login(@RequestBody Map<String,String> body){
        String username = body.get("username");
        String password = body.get("password");

        if(username == "" || password == ""){
            throw new BusinessException(Code.BUSINESS_ERR,"输入不能为空！");
        }

        Boolean success = loginService.login(username,password);

        return new Result(success);
    }
}
