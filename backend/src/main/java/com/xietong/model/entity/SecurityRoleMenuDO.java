package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Configuration;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("security_role_menu")

public class SecurityRoleMenuDO {

    @TableId(type = IdType.AUTO)
    private long id;

    @TableField(value = "role_id")
    private long roleId;

    @TableField(value = "menu_id")
    private long menuId;
}
