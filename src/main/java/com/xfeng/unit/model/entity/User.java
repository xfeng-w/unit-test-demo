package com.xfeng.unit.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.xfeng.unit.model.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author xuefeng.wang
 * @date 2020-05-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    private static final long serialVersionUID = 8631062901085084905L;

    /**
     * 名称
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐值
     */
    private String salt;

    /**
     * 角色id集合
     */
    @TableField(exist = false)
    private Set<Long> roleIds;


}
