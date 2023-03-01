package com.job;

import cn.hutool.core.lang.Snowflake;
import com.job.common.enums.Role;
import com.job.common.utils.JwtUtils;
import com.job.common.utils.SnowflakeIdUtil;
import com.job.entities.Amount;
import com.job.mapper.AmountMapper;
import com.job.modules.Login.service.MenuService;
import io.jsonwebtoken.Jwt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;

@SpringBootTest
class JobBackendApplicationTests {

    @Autowired
    private AmountMapper amountMapper;

    @Test
    void contextLoads() throws Exception {
//        e10adc3949ba59abbe56e057f20f883e

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("e10adc3949ba59abbe56e057f20f883e"));
    }


    @Autowired
    MenuService menuService;
    @Test
    void test(){
        menuService.getSonMenu(0);
    }

}
