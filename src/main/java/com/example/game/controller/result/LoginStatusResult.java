package com.example.game.controller.result;

import lombok.Data;

@Data
public class LoginStatusResult {

    public LoginStatusResult(boolean isLogin) {
        this.isLogin = isLogin;
    }

    private boolean isLogin;
}
