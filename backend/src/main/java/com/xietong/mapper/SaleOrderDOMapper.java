package com.xietong.mapper;

import com.xietong.model.entity.SaleOrderDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleOrderDOMapper {
    int insert(SaleOrderDO saleOrderDO);
    List<SaleOrderDO> listA();
    List<SaleOrderDO> listB();
    List<SaleOrderDO> getByIdA(int saleId);
    List<SaleOrderDO> getByIdB(int saleId);
    int confirmStatus(int saleId,int status);
    int confirmDeliveryStatus(int saleId,int deliveryStatus);
    int deleteBySaleId(int saleId);
}

