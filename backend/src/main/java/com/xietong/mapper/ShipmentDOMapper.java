package com.xietong.mapper;

import com.xietong.model.entity.ShipmentDO;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentDOMapper {
    public void insert(ShipmentDO shipmentDO);
}
