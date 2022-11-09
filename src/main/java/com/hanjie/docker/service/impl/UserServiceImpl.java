package com.hanjie.docker.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanjie.docker.entity.User;
import com.hanjie.docker.mapper.UserMapper;
import com.hanjie.docker.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hanjie
 * @since 2022-11-07 10:55:34
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public static final String CACHE_KEY_USER = "user:";

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void addUser(User user) {
        int insert = userMapper.insert(user);
        if (insert > 0) {
            user = userMapper.selectById(user.getId());

            String key = CACHE_KEY_USER + user.getId();

            redisTemplate.opsForValue().set(key, user);
        }

    }

    @Override
    public User findUserById(Integer id) {
        User user = null;
        String key = CACHE_KEY_USER + id;

        user = (User) redisTemplate.opsForValue().get(key);
        if (user == null) {
            user = userMapper.selectById(id);
            if (user == null) {
                return user;
            } else {
                redisTemplate.opsForValue().set(key, user);
            }
        }
        return user;
    }
}
