package com.example.game.enums;

public enum GenderEnum {

    MALE("男性"),
    FEMALE("女性"),
    UN_KNOW("未知"),
    ;

    public String desc;

    GenderEnum(String desc) {
        this.desc = desc;
    }
}
