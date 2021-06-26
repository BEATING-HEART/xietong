package com.xietong.service.intf;

import com.xietong.model.entity.CustomerDO;
import org.springframework.cache.config.CacheManagementConfigUtils;

import java.util.List;
import java.util.Map;

public interface CustomerDOService {
    List<CustomerDO> list();

    CustomerDO getById(int customerId);

    boolean update(CustomerDO customerDO);

    boolean updateStatus(int customerId, int effective);

    boolean insert(CustomerDO customerDO);
}
