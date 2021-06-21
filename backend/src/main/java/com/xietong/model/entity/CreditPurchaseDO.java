package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class CreditPurchaseDO {
    @TableId
    private int creditPurchaseId;
    private int customerId;
    private float amount;
    private Date time;
    private String remarks;

    public CreditPurchaseDO(int customerId, float amount, Date time) {
        this.customerId = customerId;
        this.amount = amount;
        this.time = time;
    }
}
