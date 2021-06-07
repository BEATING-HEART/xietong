package com.xietong.service.intf;

import com.xietong.model.entity.SecurityRoleDO;

import java.util.List;

public interface SecurityRoleDOService {
    public List<SecurityRoleDO> findAll();
    public List<SecurityRoleDO> findOneById(Long id);
    public int insert(SecurityRoleDO securityRoleDO);
    public  int removeOne(Long id);
}
