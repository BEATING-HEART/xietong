package com.xietong.service.intf;

import com.xietong.model.entity.ShipmentDO;

public interface DeliveryService {
    ShipmentDO getById(int shipmentId);
}
