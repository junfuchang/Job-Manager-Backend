package com.job;

import cn.hutool.core.lang.Snowflake;
import com.job.common.utils.JwtUtils;
import com.job.common.utils.SnowflakeIdUtil;
import io.jsonwebtoken.Jwt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class JobBackendApplicationTests {

    @Test
    void contextLoads() throws Exception {
        String sb = JwtUtils.createJWT("aabc");
        System.out.println(JwtUtils.isExpiration(sb));
    }

}
