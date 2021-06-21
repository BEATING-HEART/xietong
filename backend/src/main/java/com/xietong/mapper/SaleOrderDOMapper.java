package com.xietong.mapper;

import com.xietong.model.entity.SaleOrderDO;
import com.xietong.model.entity.SaleProductDO;
import com.xietong.model.entity.receiveDO.SaleOrderSCNameDO;
import com.xietong.model.entity.receiveDO.SaleOrderWithPriceMapDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleOrderDOMapper {
    int insert(SaleOrderDO saleOrderDO);
    List<SaleOrderDO> listA();
    List<SaleOrderSCNameDO> listC();
    List<SaleOrderDO> listB();
    List<SaleOrderDO> getByIdA(int saleId);
    List<SaleOrderDO> getByIdB(int saleId);
    List<SaleOrderSCNameDO> getByIdC(int saleId);
    int confirmStatus(int saleId,int status);
    int confirmDeliveryStatus(int saleId,int deliveryStatus);
    int deleteBySaleId(int saleId);
    SaleOrderDO getByShipmentId(int shipmentId);
    List<SaleProductDO> getSaleProductBySaleId(int saleId);
}

