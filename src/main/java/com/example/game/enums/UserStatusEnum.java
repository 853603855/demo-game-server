package com.example.game.enums;

public enum UserStatusEnum {

    USAGE("可用"),

    DISABLED("禁用"),
    ;

    public String desc;

    UserStatusEnum(String desc) {
        this.desc = desc;
    }
}
