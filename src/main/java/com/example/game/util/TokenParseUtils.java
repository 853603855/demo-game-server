package com.example.game.util;

import cn.dev33.satoken.stp.StpUtil;
import com.example.game.logic.exception.ExceptionCodeEnum;

public class TokenParseUtils {

    public static long getUserIdByToken(String token){

        ExceptionCodeEnum.TOKEN_IS_EMPTY.assertNonNull(token);

        Object value = StpUtil.getLoginIdByToken(token);
        ExceptionCodeEnum.TOKEN_PARSE_ERROR.assertNonNull(value);

        return Long.parseLong(String.valueOf(value));
    }
}
