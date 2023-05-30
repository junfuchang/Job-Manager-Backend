package com.job;

import com.job.mapper.AmountMapper;
import com.job.modules.Menu.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
