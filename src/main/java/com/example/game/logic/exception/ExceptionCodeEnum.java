package com.example.game.logic.exception;

import com.iohao.game.action.skeleton.core.exception.MsgExceptionInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * 断言 + 异常机制
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ExceptionCodeEnum implements MsgExceptionInfo {
    LOGIN_ERROR(101, "登录异常"),
    ACCOUNT_ONLINE(102, "已在线上，请勿重复登录"),
    USER_DOES_NOT_EXIST(103,"用户不存在"),
    NO_LOGIN(104, "未登录"),
    TOKEN_IS_EMPTY(105, "token为空"),
    TOKEN_PARSE_ERROR(106,"token解析错误"),
    OPERATOR_FAIL(107,"操作失败"),
    ;

    /** 消息码 */
    final int code;
    /** 消息模板 */
    final String msg;

    ExceptionCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
