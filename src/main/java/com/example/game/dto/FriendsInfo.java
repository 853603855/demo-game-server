package com.example.game.dto;

import lombok.Data;

@Data
public class FriendsInfo {

    /**
     * ID
     */
    private Long id;

    /**
     * 好友姓名
     */
    private String friendsName;

    /**
     * 头像url
     */
    private String avatar;

    /**
     * 性别 1.男 2.女 3.未知
     */
    private String gender;

    /**
     * 繁荣度
     */
    private Integer prosperityValue;

    /**
     * 城市等级
     */
    private String cityLevel;
}
