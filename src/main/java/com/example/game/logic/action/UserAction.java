package com.example.game.logic.action;

import cn.dev33.satoken.stp.StpUtil;
import com.example.game.entity.User;
import com.example.game.logic.cmd.UserCmdModule;
import com.example.game.logic.exception.ExceptionCodeEnum;
import com.example.game.logic.pb.LoginVerify;
import com.example.game.logic.pb.TokenReq;
import com.example.game.logic.pb.UserInfoResp;
import com.example.game.service.UserService;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.core.exception.MsgException;
import com.iohao.game.action.skeleton.core.flow.FlowContext;
import com.iohao.game.bolt.broker.client.kit.ExternalCommunicationKit;
import com.iohao.game.bolt.broker.client.kit.UserIdSettingKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 玩家逻辑服模块
 *
 * @author
 * @date 2023-09-18
 */
@Slf4j
@Component
@ActionController(UserCmdModule.cmd)
public class UserAction {

    @Resource
    private UserService userService;

    /**
     * 登录
     */
    @ActionMethod(UserCmdModule.login)
    public UserInfoResp login(LoginVerify req, FlowContext flowContext) throws MsgException {

        Object value = StpUtil.getLoginIdByToken(req.token);
        ExceptionCodeEnum.USER_DOES_NOT_EXIST.assertNonNull(value);

        long userId = Long.parseLong(String.valueOf(value));
        User user = userService.getById(userId);

        // channel 中设置用户的真实 userId
        boolean flag = UserIdSettingKit.settingUserId(flowContext, userId);
        ExceptionCodeEnum.LOGIN_ERROR.assertFalse(flag);


        UserInfoResp resp = new UserInfoResp();
        resp.user = user;
        return resp;
    }

    /**
     * 用户信息查询
     */
    @ActionMethod(UserCmdModule.info)
    public UserInfoResp userInfo(TokenReq req) {

        Object value = StpUtil.getLoginIdByToken(req.token);
        ExceptionCodeEnum.USER_DOES_NOT_EXIST.assertNonNull(value);

        long userId = Long.parseLong(String.valueOf(value));

        boolean flag = ExternalCommunicationKit.existUser(userId);
        ExceptionCodeEnum.NO_LOGIN.assertFalse(flag);

        User user = userService.getById(userId);
        UserInfoResp resp = new UserInfoResp();
        resp.user = user;
        return resp;
    }
}
