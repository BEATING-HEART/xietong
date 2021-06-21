package com.xietong.service.intf;

import com.xietong.model.entity.ShipmentDO;
import com.xietong.model.entity.receiveDO.SaleWaitDeliver;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DeliveryService {
    ShipmentDO getById(int shipmentId);
    Boolean deliver(Map<String ,Object> params);
    List<SaleWaitDeliver> getDeliverSale();
}
