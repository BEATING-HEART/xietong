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
@TableName("security_menu")

public class SecurityMenuDO {

    @TableId(type = IdType.AUTO)
    private long id;

    @TableField(value = "parent_id")
    private long parentId;

    private String name;
    private String path;
    private String perms;
    private String component;
    private int type;
    private String icon;
    private int orderNum;
    private int status;
}
