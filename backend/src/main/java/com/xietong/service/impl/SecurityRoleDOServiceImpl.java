package com.xietong.service.impl;

import com.xietong.mapper.SecurityRoleDOMapper;
import com.xietong.model.entity.SecurityRoleDO;
import com.xietong.service.intf.SecurityRoleDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SecurityRoleDOServiceImpl implements SecurityRoleDOService {
    @Autowired
    private SecurityRoleDOMapper securityRoleDOMapper;
    @Override
    public List<SecurityRoleDO> findAll() {
        return securityRoleDOMapper.findAll();
    }

    @Override
    public List<SecurityRoleDO> findOneById(Long id) {
        return securityRoleDOMapper.findOneById(id);
    }

    @Override
    public int insert(SecurityRoleDO securityRoleDO) {
        return securityRoleDOMapper.insert(securityRoleDO);
    }

    @Override
    public int removeOne(Long id) {
        return securityRoleDOMapper.removeOne(id);
    }

    @Override
    public List<SecurityRoleDO> listRolesByStaffId(String staffId) {
        return securityRoleDOMapper.listRolesByStaffId(staffId);
    }
}
