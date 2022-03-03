package com.xietong.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xietong.model.entity.CustomerDO;

import java.util.List;
import java.util.Map;


public interface CustomerDOService {
    ServiceImpl

    List<CustomerDO> list();

    List<CustomerDO> getById(int customerId);

    boolean update(Map<String, Object> params);

    boolean updateStatus(int customerId, int effective);

    boolean insert(Map<String, Object> params);
}
