package com.xietong.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xietong.mapper.SaleOrderDOMapper;
import com.xietong.mapper.SaleProductDOMapper;
import com.xietong.mapper.ShipmentDOMapper;
import com.xietong.mapper.ShipmentProductDOMapper;
import com.xietong.model.entity.SaleOrderDO;
import com.xietong.model.entity.SaleProductDO;
import com.xietong.model.entity.ShipmentDO;
import com.xietong.model.entity.ShipmentProductDO;
import com.xietong.service.intf.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class SaleOrderServiceImpl implements SaleOrderService {
    @Autowired
    private SaleOrderDOMapper saleOrderDOMapper;
    @Autowired
    private SaleProductDOMapper saleProductDOMapper;
    @Autowired
    private ShipmentDOMapper shipmentDOMapper;
    @Autowired
    ShipmentProductDOMapper shipmentProductDOMapper;
    @Override
    public Boolean insert(Map<String, Object> params) throws ParseException {
        //1.插入销售单表sales_order,取得主键saleId
        SaleOrderDO saleOrderDO=new SaleOrderDO(params.get("sellerId").toString(),Integer.parseInt(params.get("customerId").toString()),params.get("remarks").toString(),new Date());
        saleOrderDOMapper.insert(saleOrderDO);
        int returnSaleID=saleOrderDO.getSaleId();
        //2.插入sales_product表
        JSONArray saleProductArray= JSONArray.parseArray(JSON.toJSONString(params.get("salesProduct")));
        List<SaleProductDO> saleProductDOList= JSONObject.parseArray(saleProductArray.toString(), SaleProductDO.class);
        for (int i=0;i<saleProductDOList.size();i++){
            saleProductDOList.get(i).setSaleId(returnSaleID);
        }
        try{
            saleProductDOMapper.insertList(saleProductDOList);
        }catch (DataAccessException e){
            System.out.println(e);
            return false;
        }
        //3.插入shipment表,插入shipment_product表
        JSONObject jsonObject;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        ShipmentDO shipmentDO;
        List<ShipmentProductDO> shipmentProductDOList;
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(params.get("shipment")));


        for (int i=0;i<array.size();i++){
             jsonObject= (JSONObject) array.get(i);
             shipmentDO=new ShipmentDO(returnSaleID,simpleDateFormat.parse(jsonObject.getString("time")));
            try{
                shipmentDOMapper.insert(shipmentDO);
            }catch (DataAccessException e){
                System.out.println(e);
                return false;
            }
             int returnShipmentId=shipmentDO.getShipmentId();

             shipmentProductDOList=JSONObject.parseArray(jsonObject.getString("shipmentProduct"),ShipmentProductDO.class);
             for (int j=0;j<shipmentProductDOList.size();j++){
                 shipmentProductDOList.get(j).setShipmentId(returnShipmentId);
             }
            try{
                shipmentProductDOMapper.insertList(shipmentProductDOList);
            }catch (DataAccessException e){
                System.out.println(e);
                return false;
            }
        }
        return true;
    }
}
