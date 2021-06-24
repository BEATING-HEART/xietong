package com.xietong.service.intf;

import com.xietong.model.entity.OutboundDO;
import com.xietong.model.entity.ShipmentProductDO;
import com.xietong.model.entity.receiveDO.OutboundNameDO;

import java.util.Date;
import java.util.List;

public interface OutboundDOService {
    List<OutboundNameDO> getBySaleId(int saleId);
    List<OutboundNameDO> getByTime(Date time);
}
