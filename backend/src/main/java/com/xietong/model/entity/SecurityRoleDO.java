package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@TableName("security_role")
public class SecurityRoleDO {
    @TableId
    private int id;
    private String name;
    private String code;
    private String remark;
    private String status;
}
