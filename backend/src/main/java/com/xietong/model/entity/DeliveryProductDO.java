package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryProductDO {
    @TableId
    private int productDeliveryId;
    private int deliveryId;
    private int productId;
    private int num;

    public DeliveryProductDO(int deliveryId, int productId, int num) {
        this.deliveryId = deliveryId;
        this.productId = productId;
        this.num = num;
    }
}
