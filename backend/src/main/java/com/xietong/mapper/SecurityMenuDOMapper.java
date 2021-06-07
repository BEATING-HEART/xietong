package com.xietong.mapper;


import com.xietong.model.entity.SecurityMenuDO;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SecurityMenuDOMapper {
    List<SecurityMenuDO> findAll();
    List<SecurityMenuDO> findOneById(int id);
    int insertOne(SecurityMenuDO securityMenuDO);
    int removeOne(int id);
}
