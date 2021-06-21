package com.xietong.mapper;

import com.xietong.model.entity.OutboundDO;
import com.xietong.model.entity.OutboundProductDO;
import com.xietong.model.entity.ShipmentProductDO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OutboundDOMapper {
    int insertOutboundDO(OutboundDO outboundDO);
    int insertOutboundPProductList(List<ShipmentProductDO> shipmentProductDOList,int outboundId);
}
