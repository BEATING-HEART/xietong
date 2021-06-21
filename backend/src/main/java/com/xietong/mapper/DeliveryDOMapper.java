package com.xietong.mapper;

import com.xietong.model.entity.DeliveryDO;
import com.xietong.model.entity.DeliveryProductDO;
import com.xietong.model.entity.ShipmentProductDO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeliveryDOMapper {
    int insertDeliveryDO(DeliveryDO deliveryDO);
    int insertDeliveryProductDO(List<ShipmentProductDO> shipmentProductDOList,int deliveryId);
}
