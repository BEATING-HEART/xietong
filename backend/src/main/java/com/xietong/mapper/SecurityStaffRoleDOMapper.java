package com.xietong.mapper;

import com.xietong.model.entity.SecurityRoleDO;
import com.xietong.model.entity.SecurityStaffRoleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityStaffRoleDOMapper {
    public List<SecurityStaffRoleDO> findAll();
    public List<SecurityStaffRoleDO> findOneById(Long id);
    public int insert(SecurityStaffRoleDO securityStaffRoleDO);
    public  int removeOne(Long id);
}
