package com.xietong.model.entity.receiveDO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleProductPNameDO {
    @TableId
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int saleId;
    @TableId
    private String productName;
    private int productId;
    private float unitPrice;
    private int num;

    public SaleProductPNameDO(String productName, int productId, float unitPrice, int num) {
        this.productName = productName;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.num = num;
    }
}
