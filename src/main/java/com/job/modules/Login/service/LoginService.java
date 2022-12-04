package com.job.modules.Login.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LoginService {
    Boolean login(String username,String password);
}
