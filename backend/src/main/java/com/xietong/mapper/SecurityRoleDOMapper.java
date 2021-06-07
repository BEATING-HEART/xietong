package com.xietong.mapper;

import com.xietong.model.entity.SecurityRoleDO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SecurityRoleDOMapper {
    public List<SecurityRoleDO> findAll();
    public List<SecurityRoleDO> findOneById(Long id);
    public int insert(SecurityRoleDO securityRoleDO);
    public  int removeOne(Long id);
}
