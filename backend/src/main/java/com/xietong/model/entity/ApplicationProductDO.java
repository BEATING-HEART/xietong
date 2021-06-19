package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("application_product")

public class ApplicationProductDO {

    @TableId(value = "warehousing_application_id",type = IdType.AUTO )
    private long warehousingApplicationId;

    private int productId;
    private long batchId;
    private int applyNum;
    private int actulNum;

    public ApplicationProductDO(long warehousingApplicationId,int productId,long batchId,int applyNum,int actulNum)
    {
        this.warehousingApplicationId=warehousingApplicationId;
        this.productId=productId;
        this.batchId=batchId;
        this.applyNum=applyNum;
        this.actulNum=actulNum;
    }

}
