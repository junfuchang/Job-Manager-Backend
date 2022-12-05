package com.job;

import cn.hutool.core.lang.Snowflake;
import com.job.common.enums.Role;
import com.job.common.utils.JwtUtils;
import com.job.common.utils.SnowflakeIdUtil;
import io.jsonwebtoken.Jwt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;

@SpringBootTest
class JobBackendApplicationTests {

    @Test
    void contextLoads() throws Exception {
        System.out.println(Role.getCode("12"));
    }

}
