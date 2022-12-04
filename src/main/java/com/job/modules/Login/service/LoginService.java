package com.job.modules.Login.service;

import com.job.entities.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LoginService {
    String login(User user);
}
