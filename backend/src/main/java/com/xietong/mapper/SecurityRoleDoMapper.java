package com.xietong.mapper;

import com.xietong.model.entity.SecurityStaffRoleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityRoleDoMapper {
    List<SecurityStaffRoleDO> findAll();
    List<SecurityStaffRoleDO> findOneById(int id);
    List<SecurityStaffRoleDO> insert(SecurityStaffRoleDO securityStaffRoleDO);
    int removeOne(int id);

}
