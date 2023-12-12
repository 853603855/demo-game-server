package com.example.game.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表 实体类。
 *
 * @author YangX
 * @since 2023-08-02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "user", schema = "game_db")
public class User implements Serializable {

    /**
     * ID
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密SALT
     */
    private String salt;

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
     * 繁荣度
     */
    private Integer prosperityValue;

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
    private Date createAt;

    /**
     * 修改人
     */
    private Long modifyBy;

    /**
     * 修改时间
     */
    private Date modifyAt;

    /**
     * 是否删除
     */
    private Boolean isDel;
}
