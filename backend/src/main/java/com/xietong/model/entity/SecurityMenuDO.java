package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("security_menu")

public class SecurityMenuDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "parent_id")
    @NotNull(message = "上级菜单不能为空")
    private Long parentId;

    @NotBlank(message = "菜单名称不能为空")
    private String name;
    private String path;
    @NotBlank(message = "菜单授权码不能为空")
    private String perms;
    private String component;
    @NotNull(message = "菜单类型不能为空")
    private Integer type;
    private String icon;
    private Integer orderNum;
    private Boolean status;

    @TableField(exist = false)
    private List<SecurityMenuDO> children = new ArrayList<>();
}
