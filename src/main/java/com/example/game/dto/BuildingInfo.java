package com.example.game.dto;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;

@Data
public class BuildingInfo {

    /**
     * ID
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 建筑物名称
     */
    private String buildingName;

    /**
     * 建筑物类型
     */
    private String buildingType;

    /**
     * 城市等级
     */
    private String cityLevel;

    /**
     * 繁荣度
     */
    private Integer prosperity;

    /**
     * 金币数
     */
    private Integer coinNum;

    /**
     * X坐标
     */
    private Integer x;

    /**
     * Y坐标
     */
    private Integer y;
}
