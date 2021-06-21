package com.xietong.model.entity.receiveDO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.xietong.model.entity.ShipmentProductDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentWaitDeliver {
    private int shipmentId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int saleId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    private int status;
    private List<ShipmentProductWaitDeliver> shipmentProductWaitDeliverList;
}
