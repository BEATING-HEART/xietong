package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class DeliveryDO {
    @TableId
    private int deliveryId;
    private  int saleId;
    private int customerId;
    private Date time;

    public DeliveryDO(int saleId, int customerId, Date time) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.time = time;
    }
}

