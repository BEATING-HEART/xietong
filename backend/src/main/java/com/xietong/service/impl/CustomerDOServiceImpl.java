package com.xietong.service.impl;

import com.xietong.model.entity.CustomerDO;
import com.xietong.service.intf.CustomerDOService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class CustomerDOServiceImpl implements CustomerDOService {
    @Override
    public List<CustomerDO> list() {
        return null;
    }

    @Override
    public List<CustomerDO> getById(int customerId) {
        return null;
    }

    @Override
    public boolean update(Map<String, Object> params) {
        return false;
    }

    @Override
    public boolean updateStatus(int customerId, int effective) {
        return false;
    }

    @Override
    public boolean insert(Map<String, Object> params) {
        return false;
    }
}
