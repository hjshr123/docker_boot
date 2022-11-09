package com.hanjie.docker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanjie.docker.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author hanjie
 * @since 2022-11-07 10:55:34
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
