package com.xietong.mapper;

import com.xietong.model.entity.CustomerDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDOMapper {
    List<CustomerDO> list();

    CustomerDO getById(int customerId);

    boolean update(CustomerDO customerDO);

    boolean updateStatus(int customerId, int effective);

    boolean insert(CustomerDO customerDO);
}
