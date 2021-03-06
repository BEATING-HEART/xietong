package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class SaleProductDO {
    @TableId
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
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
