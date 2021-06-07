package com.xietong.service.impl;

import com.xietong.mapper.SecurityStaffRoleDOMapper;
import com.xietong.model.entity.SecurityStaffRoleDO;
import com.xietong.service.intf.SecurityStaffRoleDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityStaffRoleDOServiceImpl implements SecurityStaffRoleDOService {
    @Autowired
    private SecurityStaffRoleDOMapper securityStaffRoleDOMapper;
    @Override
    public List<SecurityStaffRoleDO> findAll() {
        return securityStaffRoleDOMapper.findAll();
    }

    @Override
    public List<SecurityStaffRoleDO> findOneById(Long id) {
        return securityStaffRoleDOMapper.findOneById(id);
    }

    @Override
    public int insert(SecurityStaffRoleDO securityStaffRoleDO) {
        return securityStaffRoleDOMapper.insert(securityStaffRoleDO);
    }

    @Override
    public int removeOne(Long id) {
        return securityStaffRoleDOMapper.removeOne(id);
    }
}
