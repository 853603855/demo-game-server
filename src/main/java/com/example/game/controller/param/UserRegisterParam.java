package com.example.game.controller.param;

import com.example.game.enums.GenderEnum;
import lombok.Data;

@Data
public class UserRegisterParam {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private GenderEnum gender = GenderEnum.UN_KNOW;
}
