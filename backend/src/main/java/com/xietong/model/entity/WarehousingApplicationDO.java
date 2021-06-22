package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName("warehousing_application")

public class WarehousingApplicationDO {
    @TableId(value = "warehousing_application_id",type = IdType.AUTO )
    private long warehousingApplicationId;

    private String staffId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;

    private int workshopId;

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
