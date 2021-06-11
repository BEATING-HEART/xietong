package com.xietong.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShipmentProductDO {
    private int shipmentId;
    private int productId;
    private int num;

    public ShipmentProductDO() {
    }

    public ShipmentProductDO(int productId, int num) {
        this.productId = productId;
        this.num = num;
    }
}
