package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName("warehousing_application")

public class WarehousingApplicationDO {
    @TableId(value = "warehousing_application_id",type = IdType.AUTO )
//    @ApiModelProperty(hidden=true)
    private long warehousingApplicationId;

    @ApiModelProperty(hidden=true)
    private String staffId;

    @TableField(exist = false)
    @ApiModelProperty(hidden=true)
    private String staffName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(hidden=true)
    private Date time;

    @ApiModelProperty(hidden=true)
    private int workshopId;

    @ApiModelProperty(hidden=true)
    private int status;

    @TableField(exist = false)
    private List<ApplicationProductDO> applicationProducts;


//    public WarehousingApplicationDO(long warehousingApplicationId, String staffId, Date time, int workshopId, int status) {
//        this.warehousingApplicationId=warehousingApplicationId;
//        this.staffId=staffId;
//        this.time=time;
//        this.workshopId=workshopId;
//        this.status=status;
//    }
}
