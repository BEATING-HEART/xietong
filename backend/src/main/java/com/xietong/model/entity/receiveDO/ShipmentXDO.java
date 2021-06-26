package com.xietong.model.entity.receiveDO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentXDO {
    private int shipmentNum;
    private int productId;
    private int num;
    private String time;
    private String productName;

    public ShipmentXDO(int shipmentNum, int productId, int num, String time) {
        this.shipmentNum = shipmentNum;
        this.productId = productId;
        this.num = num;
        this.time = time;
    }
}
