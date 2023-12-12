package com.example.game.dto;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;

import java.util.Date;

@Data
public class WarehouseMaterialInfo {

    /**
     * ID
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 物料ID
     */
    private Integer materialId;

    /**
     * 物料名称
     */
    private String materialName;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 修改人
     */
    private Long modifyBy;

    /**
     * 修改时间
     */
    private Date modifyAt;
}
