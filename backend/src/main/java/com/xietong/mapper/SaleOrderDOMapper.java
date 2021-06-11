package com.xietong.mapper;

import com.xietong.model.entity.SaleOrderDO;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOrderDOMapper {
    int insert(SaleOrderDO saleOrderDO);
}
