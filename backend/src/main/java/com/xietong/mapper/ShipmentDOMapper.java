package com.xietong.mapper;

import com.xietong.model.entity.ShipmentDO;
import com.xietong.model.entity.receiveDO.SaleWaitDeliver;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShipmentDOMapper {
    public void insert(ShipmentDO shipmentDO);
    int deleteByShipmentId(int shipmentId);
    int deleteBySaleId(int saleId);
    List<ShipmentDO> ListBySaleId(int saleId);
    ShipmentDO getById(int shipmentId);
    int updateStatus(int shipmentId);
    List<ShipmentDO> getShipmentListBySaleId(int saleId);
    int getShipmentStatus(int shipmentId);
    List<SaleWaitDeliver> getDeliverSale(Date time);
}
