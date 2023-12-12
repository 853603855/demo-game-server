package com.example.game.dto;

import lombok.Data;

@Data
public class MaterialInfo {

    /**
     * ID
     */
    private Integer id;

    /**
     * 原料名称
     */
    private String materialName;

    /**
     * 原料类型
     */
    private String materialType;

    /**
     * 产生经验值
     */
    private Integer outputExpValue;
}
