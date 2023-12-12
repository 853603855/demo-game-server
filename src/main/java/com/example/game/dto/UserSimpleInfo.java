package com.example.game.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserSimpleInfo {

    /**
     * ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像url
     */
    private String avatar;

    /**
     * 性别 1.男 2.女 3.未知
     */
    private String gender;

    /**
     * 经验值
     */
    private Integer expValue;

    /**
     * 城市等级
     */
    private String cityLevel;

    /**
     * 金币数
     */
    private Integer coinNum;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    /**
     * 修改人
     */
    private Long modifyBy;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyAt;
}
