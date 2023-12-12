package com.example.game.dto;

import lombok.Data;

@Data
public class UserFishingInfo {

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 经验值
     */
    private Integer expValue;

    /**
     * 可用渔网数
     */
    private Integer netNum;
}
