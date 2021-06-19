package com.xietong.service.impl;

import com.xietong.mapper.ShipmentDOMapper;
import com.xietong.model.entity.ShipmentDO;
import com.xietong.service.intf.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private ShipmentDOMapper shipmentDOMapper;

    @Override
    public ShipmentDO getById(int shipmentId) {
        return shipmentDOMapper.getById(shipmentId);
    }
}
