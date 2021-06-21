package com.xietong.mapper;

import com.xietong.model.entity.CreditPurchaseDO;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditPurchaseDOMapper {
    int insertCreditPurchaseDO(CreditPurchaseDO creditPurchaseDO);
}
