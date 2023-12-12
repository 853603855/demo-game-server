package com.example.game.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CropsInfo {

    /**
     * ID
     */
    private Long id;

    /**
     * 农作物名称
     */
    private String cropsName;

    /**
     * 农作物类型
     */
    private String cropsType;

    /**
     * 产出数
     */
    private Integer produceNum;

    /**
     * 成熟时长（单位：秒）
     */
    private Integer growthTime;

    /**
     * 种植时间
     */
    private Date plantAt;

    /**
     * X坐标
     */
    private Integer x;

    /**
     * Y坐标
     */
    private Integer y;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createAt;
}
