package com.xietong.model.entity.receiveDO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xietong.model.entity.SaleProductDO;
import com.xietong.model.entity.ShipmentDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleWaitDeliver {
    @TableId
    private int saleId;
    private String sellerName;
    private String customerName;
    private String remarks;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    private List<ShipmentWaitDeliver> shipmentWaitDeliverList;

    public List<ShipmentWaitDeliver> getShipmentWaitDeliverList() {
        return shipmentWaitDeliverList;
    }
}
