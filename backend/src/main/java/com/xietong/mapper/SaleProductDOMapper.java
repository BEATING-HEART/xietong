package com.xietong.mapper;

import com.xietong.model.entity.SaleProductDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleProductDOMapper {
    int insertList(@Param("saleProductDOList")List<SaleProductDO> saleProductDOList);
    int deleteBySaleId(int saleId);
    int deleteBySaleAndProductId(int saleId,int productId);
    List<SaleProductDO> listBySaleId(int saleId);
}
