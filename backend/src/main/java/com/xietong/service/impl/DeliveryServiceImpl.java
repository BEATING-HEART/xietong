package com.xietong.service.impl;

import com.xietong.mapper.*;
import com.xietong.model.entity.*;
import com.xietong.model.entity.receiveDO.SaleOrderWithPriceMapDO;
import com.xietong.service.intf.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private ShipmentDOMapper shipmentDOMapper;
    @Autowired
    private SaleOrderDOMapper saleOrderDOMapper;
    @Autowired
    private OutboundDOMapper outboundDOMapper;
    @Autowired
    private DeliveryDOMapper deliveryDOMapper;
    @Autowired
    private CreditPurchaseDOMapper creditPurchaseDOMapper;

    @Override
    public ShipmentDO getById(int shipmentId) {
        return shipmentDOMapper.getById(shipmentId);
    }

    @Override
    public Boolean deliver(Map<String, Object> params) {
        //判断是否该批次已发货
        if (shipmentDOMapper.getShipmentStatus(Integer.parseInt(params.get("shipmentId").toString()))==1){
            return false;
        }
        //1.取得对应销售单
        SaleOrderDO saleOrderDO=saleOrderDOMapper.getByShipmentId(Integer.parseInt(params.get("shipmentId").toString()));
        System.out.println(saleOrderDO);
        List<SaleProductDO> saleProductDOList=saleOrderDOMapper.getSaleProductBySaleId(saleOrderDO.getSaleId());
        System.out.println(saleProductDOList);
        //2.取得对应批次及批次产品记录
        ShipmentDO shipmentDO=shipmentDOMapper.getById(Integer.parseInt(params.get("shipmentId").toString()));
        System.out.println(shipmentDO);
        float amount=0;
        for (int i=0;i<shipmentDO.getShipmentProductDOList().size();i++){
            for (int j=0;j<saleProductDOList.size();j++){
                if (shipmentDO.getShipmentProductDOList().get(i).getProductId()==saleProductDOList.get(j).getProductId()){
                    amount=amount+shipmentDO.getShipmentProductDOList().get(i).getNum()*saleProductDOList.get(j).getUnitPrice();
                    break;
                }
            }
        }
        creditPurchaseDOMapper.insertCreditPurchaseDO(new CreditPurchaseDO(saleOrderDO.getCustomerId(),amount,new Date()));
        //3.添加出库单，发货单，赊购单
        OutboundDO outboundDO=new OutboundDO(saleOrderDO.getSaleId(),params.get("staffId").toString(),saleOrderDO.getCustomerId(),new Date(),Integer.parseInt(params.get("shipmentId").toString()));
        outboundDOMapper.insertOutboundDO(outboundDO);
        DeliveryDO deliveryDO=new DeliveryDO(saleOrderDO.getSaleId(),saleOrderDO.getCustomerId(),new Date());
        deliveryDOMapper.insertDeliveryDO(deliveryDO);
        System.out.println(outboundDO.getOutboundId());
        System.out.println(deliveryDO.getDeliveryId());
        //4.根据批次产品记录组成出库-产品，发货-产品记录
        outboundDOMapper.insertOutboundPProductList(shipmentDO.getShipmentProductDOList(),outboundDO.getOutboundId());
        deliveryDOMapper.insertDeliveryProductDO(shipmentDO.getShipmentProductDOList(),deliveryDO.getDeliveryId());
        //5.修改发货批次记录发货状态
        shipmentDOMapper.updateStatus(Integer.parseInt(params.get("shipmentId").toString()));
        //6.检查销售单的发货完成状态（修改）
        List<ShipmentDO> shipmentDOList=shipmentDOMapper.getShipmentListBySaleId(saleOrderDO.getSaleId());
        int deliveredNum=0;
        for (int i=0;i<shipmentDOList.size();i++){
            if (shipmentDOList.get(i).getStatus()==1){
                deliveredNum++;
            }
        }
        if (deliveredNum==shipmentDOList.size()){
            saleOrderDOMapper.confirmDeliveryStatus(saleOrderDO.getSaleId(),1);
        }
        return true;
    }
}
