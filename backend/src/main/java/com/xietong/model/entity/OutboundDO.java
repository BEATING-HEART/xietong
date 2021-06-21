package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class OutboundDO {
    @TableId
    private int outboundId;
    private int saleId;
    private String staffId;
    private int customerId;
    private Date time;
    private int shipmentId;

    public OutboundDO(int saleId, String staffId, int customerId, Date time, int shipmentId) {
        this.saleId = saleId;
        this.staffId = staffId;
        this.customerId = customerId;
        this.time = time;
        this.shipmentId = shipmentId;
    }

}
