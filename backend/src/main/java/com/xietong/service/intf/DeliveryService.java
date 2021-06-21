package com.xietong.service.intf;

import com.xietong.model.entity.ShipmentDO;

import java.util.Map;

public interface DeliveryService {
    ShipmentDO getById(int shipmentId);
    Boolean deliver(Map<String ,Object> params);
}
