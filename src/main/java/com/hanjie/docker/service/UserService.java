package com.hanjie.docker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanjie.docker.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author hanjie
 * @since 2022-11-07 10:55:34
 */
public interface UserService extends IService<User> {

    void addUser(User user);

    User findUserById(Integer id);
}
