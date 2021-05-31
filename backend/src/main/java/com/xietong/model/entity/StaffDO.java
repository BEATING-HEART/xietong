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
@TableName("staff")
//@Configuration
public class StaffDO {
    @TableId(value = "stuff_id", type = IdType.INPUT)
    private String stuffId;
    private String stuffPwd;
    private String stuffPosition;
    private String stuffName;
    private Boolean validity;

    // 入职时间？离职时间？
}
