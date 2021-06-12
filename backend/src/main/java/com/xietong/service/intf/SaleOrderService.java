package com.xietong.service.intf;

import com.xietong.model.entity.SaleOrderDO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface SaleOrderService {
    public Boolean insert(Map<String ,Object> params) throws ParseException;
    List<SaleOrderDO> list();
    public List<SaleOrderDO> getById(int saleId);
}
