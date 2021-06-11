package com.xietong.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleProductDO {
    private int saleId;
    private int productId;
    private float unitPrice;
    private int num;

    public SaleProductDO() {
    }

    public SaleProductDO(int productId, float unitPrice, int num) {
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.num = num;
    }
}
