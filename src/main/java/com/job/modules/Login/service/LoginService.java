package com.job.modules.Login.service;

import com.job.common.domain.Result;
import com.job.entities.Amount;
import com.job.modules.Login.dto.CompanyRegister;
import com.job.modules.Login.dto.StudentRegister;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

@Transactional
public interface LoginService {
    HashMap login(Amount user);
    Result studentRegister(StudentRegister studentRegister) throws InvocationTargetException, IllegalAccessException;
    Result companyRegister(CompanyRegister companyRegister) throws InvocationTargetException, IllegalAccessException;
    /**
     * 暴露出去用于检查用户名是否已经存在
     */
    Boolean checkAmountAvailable(String username);
}
