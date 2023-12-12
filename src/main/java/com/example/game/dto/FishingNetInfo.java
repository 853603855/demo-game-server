package com.example.game.dto;

import lombok.Data;

@Data
public class FishingNetInfo {

    /**
     * ID
     */
    private Long id;

    /**
     * 渔网类型
     */
    private String netType;

    /**
     * 鱼ID
     */
    private Long fishId;

    /**
     * 原料ID
     */
    private Long materialId;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 收获状态
     */
    private String status;
}
