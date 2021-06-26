package com.xietong.service.impl;

import com.xietong.mapper.CustomerDOMapper;
import com.xietong.model.entity.CustomerDO;
import com.xietong.service.intf.CustomerDOService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class CustomerDOServiceImpl implements CustomerDOService {
    @Autowired
    private CustomerDOMapper customerDOMapper;

    @Override
    public List<CustomerDO> list() {
        List<CustomerDO> listCustomer = customerDOMapper.list();
        return listCustomer;
    }

    @Override
    public CustomerDO getById(int customerId) {
        return customerDOMapper.getById(customerId);
    }

    @Override
    public boolean update(CustomerDO customerDO) {
        customerDOMapper.update(customerDO);
        return true;
    }

    @Override
    public boolean updateStatus(@Param("customerId") int customerId,@Param("effective") int effective) {
        if(customerDOMapper.updateStatus(customerId,effective))
        return true;
        else return false;
    }

    @Override
    public boolean insert(CustomerDO customerDO) {
        customerDOMapper.insert(customerDO);
        return true;
    }
}
