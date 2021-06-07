package com.xietong.service.impl;

import com.xietong.mapper.SecurityMenuDOMapper;
import com.xietong.model.entity.SecurityMenuDO;
import com.xietong.service.intf.SecurityMenuDOService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityMenuDOServiceImpl implements SecurityMenuDOService {
    @Autowired
    private SecurityMenuDOMapper securityMenuDOMapper;

    @Override
    public List<SecurityMenuDO> findAll() {
        return securityMenuDOMapper.findAll();
    }

    @Override
    public List<SecurityMenuDO> findOneById(String id) {
        return securityMenuDOMapper.findOneById(Integer.parseInt(id));
    }

    @Override
    public int insertOne(SecurityMenuDO securityMenuDO) {
        return securityMenuDOMapper.insertOne(securityMenuDO);
    }

    @Override
    public int removeOne(String id) {
        return securityMenuDOMapper.removeOne(Integer.parseInt(id));
    }
}
