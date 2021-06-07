package com.xietong.service.intf;

import com.xietong.model.entity.SecurityStaffRoleDO;

import java.util.List;

public interface SecurityStaffRoleDOService {
    public List<SecurityStaffRoleDO> findAll();
    public List<SecurityStaffRoleDO> findOneById(Long id);
    public int insert(SecurityStaffRoleDO securityStaffRoleDO);
    public  int removeOne(Long id);
}
