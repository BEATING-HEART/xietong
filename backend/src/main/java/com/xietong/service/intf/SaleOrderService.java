package com.xietong.service.intf;

import com.xietong.model.entity.SaleOrderDO;
import com.xietong.model.entity.SaleProductDO;
import com.xietong.model.entity.ShipmentDO;
import com.xietong.model.entity.ShipmentProductDO;
import com.xietong.model.entity.receiveDO.SaleOrderSCNameDO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface SaleOrderService {
    //插入销售单
    public Boolean insert(Map<String ,Object> params) throws ParseException;
    //获取所有销售单全部信息
   List<SaleOrderSCNameDO> list();
    //获取某一销售单全部信息
    public List<SaleOrderSCNameDO> getById(int saleId);
    //审核通过/不通过
    int confirmStatus(int saleId,int status);
    //修改发货状态
    int confirmDeliveryStatus(int saleId,int deliveryStatus);
    //删除某一销售单及其之下的销售-产品记录，发货批次表，批次-产品记录
    Boolean deleteSale(int saleId);
    //删除某一销售-产品记录
    Boolean deleteSaleProduct(int saleId,int productId);
    //删除某一批次及其之下的所有批次-产品记录
    Boolean deleteShipment(int shipmentId);
    //删除某一批次-产品记录
    Boolean deleteShipmentProduct(int shipmentId,int productId);

    Boolean insertOneSaleProduct(SaleProductDO saleProductDO);

    int  insertShipment(ShipmentDO shipmentDO);
    Boolean insertOneShipmentProduct(List<ShipmentProductDO> shipmentProductDOList);
}
