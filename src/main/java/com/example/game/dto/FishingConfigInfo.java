package com.example.game.dto;

import lombok.Data;

@Data
public class FishingConfigInfo {

    /**
     * ID
     */
    private Long id;

    /**
     * 鱼类名称
     */
    private String fishName;

    /**
     * 钓鱼等级
     */
    private Integer fishLevel;

    /**
     * 经验值
     */
    private Integer expValue;

    /**
     * 是否解锁
     */
    private Boolean unLock;
}
