package com.example.game.mapper;

import com.example.game.entity.User;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表 映射层。
 *
 * @author YangX
 * @since 2023-07-31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getUserByUserName(@Param("userName")String userName);
}
