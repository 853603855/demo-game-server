package com.example.game.logic.cmd;

public interface UserCmdModule {

    /** 业务类型cmd */
    int cmd = PrimaryCmd.userCmd;
    /** 用户登录 */
    int login = 1;
    /** 用户详细信息 */
    int info = 2;
}
