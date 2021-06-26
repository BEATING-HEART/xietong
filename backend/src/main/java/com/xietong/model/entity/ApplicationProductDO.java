package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("application_product")

public class ApplicationProductDO {

    @TableId(value = "warehousing_application_id",type = IdType.AUTO )
    @ApiModelProperty(hidden=true)
    private long warehousingApplicationId;
    private int productId;
    @TableField(exist = false)
    private String productName;
    private long batchId;
    private int goodNum;
    private int badNum;
    @TableField(value = "apply_num")
    private int totalNum;
    @ApiModelProperty(hidden=true)
    private int actulNum;


}
