package com.hanjie.docker.controller;


import com.hanjie.docker.entity.User;
import com.hanjie.docker.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hanjie
 * @since 2022-11-07 10:55:34
 */
@RestController
@RequestMapping("/hanjie")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("数据库新增记录")
    @GetMapping("/user/add")
    public void addUser(){
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setUsername("hanjie"+i);
            user.setPassword(UUID.randomUUID().toString().substring(0,6));
            user.setSex(new Random().nextInt(2));
            user.setCreateTime(LocalDateTime.now());
            userService.addUser(user);
        }
    }

    @ApiOperation("查询记录")
    @GetMapping("/user/find/{id}")
    public User findUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }
}
