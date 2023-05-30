package com.job.modules.Login.controller;

import com.job.common.domain.Result;
import com.job.entities.Amount;
import com.job.modules.Login.dto.CompanyRegister;
import com.job.modules.Login.dto.StudentRegister;
import com.job.modules.Login.service.LoginService;
import com.job.modules.Menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = {"", "/"})
    public Result login(@RequestBody Amount amount){
        return new Result(loginService.login(amount));
    }

    @PostMapping(value = {"/studentRegister"})
    public Result stuRegister(@RequestBody StudentRegister stuInfo) throws InvocationTargetException, IllegalAccessException {
        return loginService.studentRegister(stuInfo);
    }

    @PostMapping(value = {"/companyRegister"})
    public Result companyRegister(@RequestBody CompanyRegister compInfo) throws InvocationTargetException, IllegalAccessException {
        return loginService.companyRegister(compInfo);
    }
}
