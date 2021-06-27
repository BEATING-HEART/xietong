package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Configuration;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("customer")

public class CustomerDO {
    @TableId(value = "customer_id",type = IdType.AUTO)
    private int customerId;
    @TableField(value = "customer_name")
    private String customerName;
    @TableField(value = "customer_phone")
    private String customerPhone;
    @TableField(value = "business_scope")
    private String businessScope;
    private String address;
    @ApiModelProperty(hidden=true)
    private Boolean effective;
}
