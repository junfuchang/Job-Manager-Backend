package com.job.modules.User.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.job.entities.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    /**
     * 新增用户
     * @return
     */
    Boolean saveUser(User user);

    /**
     * 删除用户 - id
     * @param id
     * @return
     */
    Boolean deleteUser(Integer id);

    /**
     * 批量删除用户
     * @param idList
     * @return
     */
    Boolean deleteUserBatch(List<Integer> idList);

    /**
     * 修改用户
     * @param user
     * @return
     */
    Boolean updateUser(User user);

    /**
     * 查询用户 - id
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 查询全部的用户
     * @return
     */
    IPage<User> getUserBySearch();

    /**
     * 查询全部的用户
     * @return
     */
    IPage<User> getUserAll();
}
