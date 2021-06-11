package com.xietong.mapper;

import com.xietong.model.entity.SaleProductDO;
import com.xietong.model.entity.ShipmentProductDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentProductDOMapper {
    void insertList(@Param("shipmentProductDOList") List<ShipmentProductDO> shipmentProductDOList);
}
