package com.example.game.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishInfo {

    /**
     * ID
     */
    private Long id;

    /**
     * 菜品名称
     */
    private String dishesName;

    /**
     * 菜品类型
     */
    private String dishesType;

    /**
     * 烹饪等级
     */
    private Integer cookingLevel;

    /**
     * 经验值
     */
    private Integer expValue;

    /**
     * 熟练度
     */
    private Integer proficiency;

    /**
     * 材料列表
     */
    private List<MaterialInfo>  materialList = new ArrayList<>();
}
