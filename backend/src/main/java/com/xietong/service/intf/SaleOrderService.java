package com.xietong.service.intf;

import java.text.ParseException;
import java.util.Map;

public interface SaleOrderService {
    public Boolean insert(Map<String ,Object> params) throws ParseException;
}
