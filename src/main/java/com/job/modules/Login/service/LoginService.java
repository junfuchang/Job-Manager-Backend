package com.job.modules.Login.service;

import com.job.entities.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Transactional
public interface LoginService {
    HashMap login(User user);
}
