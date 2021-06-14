package com.xietong.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShipmentProductDO {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
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
