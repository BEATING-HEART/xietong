package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.context.annotation.Configuration;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("staff")
public class StaffDO {
    @TableId(value = "stuff_id", type = IdType.INPUT)
    @NonNull
    private String stuffId;
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stuffPwd;
    @NonNull
    private String stuffPosition;
    @NonNull
    private String stuffName;
    @TableField(value = "effective")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean validity;
    @NonNull
    private Integer status;

    // 入职时间？离职时间？

}
