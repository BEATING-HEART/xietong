package com.xietong.model.entity.receiveDO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentProductPNameDO {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int shipmentId;
    private int productId;
    private String productName;
    private int num;

    public ShipmentProductPNameDO(int productId, String productName, int num) {
        this.productId = productId;
        this.productName = productName;
        this.num = num;
    }
}
