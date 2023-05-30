package com.job.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeUtils {
    public static String encode(String md5Password){
        //密码加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(md5Password);
       return encodedPassword;
    }
}
