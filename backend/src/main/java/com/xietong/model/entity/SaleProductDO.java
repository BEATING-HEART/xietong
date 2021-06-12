package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class SaleProductDO {
    @TableId
    private int saleId;
    @TableId
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
