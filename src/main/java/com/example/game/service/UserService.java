package com.example.game.service;

import cn.dev33.satoken.util.SaResult;
import com.example.game.controller.param.UserLoginParam;
import com.example.game.controller.param.UserRegisterParam;
import com.example.game.dto.UserSimpleInfo;
import com.example.game.entity.User;
import com.mybatisflex.core.service.IService;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * 用户表 服务层。
 *
 * @author YangX
 * @since 2023-07-31
 */
public interface UserService extends IService<User> {

    /**
     * 通过名称查询用户
     */
    User getUser(String username);

    /**
     * 用户简要信息查询
     */
    UserSimpleInfo getUserSimpleInfo(Integer userId);

    /**
     * 验证用户
     */
    Boolean verify(User currentUser, UserLoginParam param) throws NoSuchAlgorithmException;

    /**
     * 注册用户
     */
    SaResult register(UserRegisterParam user) throws NoSuchAlgorithmException;

    /**
     * 通过ids查询用户
     */
    List<User> getByIds(List<Long> ids);

    /**
     * 通过id或者名称模糊查询用户
     */
    List<User> getListByLikeIdOrLikeName(String idOrName);
}