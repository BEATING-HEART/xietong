package com.xietong.mapper;

import com.xietong.model.entity.SecurityRoleMenuDO;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SecurityRoleMenuDOMapper {
    List<SecurityRoleMenuDO> findAll();
    List<SecurityRoleMenuDO> findOneById(int id);
    List<SecurityRoleMenuDO> insertOne(SecurityRoleMenuDO securityRoleMenuDO);
    int removeOne(int id);
}
