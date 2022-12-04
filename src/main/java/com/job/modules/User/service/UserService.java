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
    Boolean save(User user);

    /**
     * 删除用户 - id
     * @param id
     * @return
     */
    Boolean delete(Integer id);

    /**
     * 批量删除用户
     * @param idList
     * @return
     */
    Boolean deleteBatch(List<Integer> idList);

    /**
     * 修改用户
     * @param user
     * @return
     */
    Boolean update(User user);

    /**
     * 查询用户 - id
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * 查询全部的用户
     * @return
     */
    IPage<User> getAll();
}
