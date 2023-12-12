package com.example.game.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.example.game.controller.param.UserRegisterParam;
import com.example.game.constant.CommonConstant;
import com.example.game.controller.param.UserLoginParam;
import com.example.game.controller.result.LoginStatusResult;
import com.example.game.controller.result.TokenResult;
import com.example.game.entity.User;
import com.example.game.route.Route;
import com.example.game.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author YangXin
 * @since 2023-08-02
 */
@RestController
@RequestMapping(Route.user.Root)
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登录
     */
    @RequestMapping(Route.user.login)
    public SaResult login(@RequestBody UserLoginParam param) throws NoSuchAlgorithmException {

        User user = userService.getUser(param.getUserName());
        if(user == null){
            return SaResult.error("用户不存在");
        }

        boolean flag = userService.verify(user, param);
        if(!flag){
            return SaResult.error("用户名或密码错误");
        }

        // 登录
        StpUtil.login(user.getId());
        // 返回token
        String token = StpUtil.getTokenValue();

        TokenResult tr = new TokenResult();
        tr.setToken(token);
        return SaResult.data(tr);
    }

    /**
     * 注册
     */
    @RequestMapping(Route.user.register)
    public SaResult register(@RequestBody UserRegisterParam param) throws NoSuchAlgorithmException {
        return userService.register(param);
    }

    /**
     * 是否登录
     */
    @RequestMapping(Route.user.isLogin)
    public SaResult isLogin(@RequestHeader(CommonConstant.TOKEN_NAME) String token) {

        if(StringUtils.isEmpty(token)){
            return SaResult.error("token为空");
        }

        Object userId = StpUtil.getLoginIdByToken(token);
        if(userId == null){
            return SaResult.data(new LoginStatusResult(false));
        }
        if(StpUtil.isLogin(userId)){// 已登录
            return SaResult.data(new LoginStatusResult(true));
        }
        return SaResult.data(new LoginStatusResult(false));
    }

    /**
     * 登出
     */
    @RequestMapping(Route.user.logout)
    public SaResult logout(@RequestHeader(CommonConstant.TOKEN_NAME) String token) {

        if(StringUtils.isEmpty(token)){
            return SaResult.error("token为空");
        }
        StpUtil.logoutByTokenValue(token);
        return SaResult.ok();
    }
}
