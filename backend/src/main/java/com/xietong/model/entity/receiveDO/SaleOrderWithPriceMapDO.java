package com.xietong.model.entity.receiveDO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.xietong.model.entity.SaleProductDO;
import com.xietong.model.entity.ShipmentDO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
public class SaleOrderWithPriceMapDO {
    @TableId
    private int saleId;
    private String sellerId;
    private String managerId;
    private int customerId;
    private String remarks;
    private Date time;
    private int status;
    private int deliveryStatus ;
    private Map<String,Float> priceMap;

}
