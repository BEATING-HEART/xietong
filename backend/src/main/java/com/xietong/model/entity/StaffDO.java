package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel
@TableName("staff")
public class StaffDO {
    @TableId(value = "stuff_id", type = IdType.INPUT)
    @NonNull @NotBlank(message = "员工id不能为空")
    @ApiModelProperty
    private String staffId;

    @NonNull @ApiModelProperty //@JsonIgnore
    private String staffPwd;

    @NonNull @NotBlank(message = "职位不能为空") @ApiModelProperty
    private String staffPosition;
    @NonNull @NotBlank(message = "员工姓名不能为空") @ApiModelProperty
    private String staffName;


    @JsonInclude(JsonInclude.Include.NON_NULL) @TableField(value = "effective")
    @ApiModelProperty(hidden=true)
    private Boolean effective;

    @NonNull @ApiModelProperty(hidden=true)//@JsonIgnore
    private Integer status;

    // 入职时间？离职时间？

}
