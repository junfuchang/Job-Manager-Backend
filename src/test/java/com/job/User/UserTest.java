package com.job.User;

import com.job.entities.User;
import com.job.modules.User.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    UserServiceImpl userService;

//    @Test
//    public List<User> userGetAll(){
//        List<User> users = userService.getAll();
//        System.out.println(users);
//        return users;
//    }
}
