package com.xietong.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xietong.model.entity.SecurityMenuDO;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SecurityMenuDOMapper  {
    List<SecurityMenuDO> findAll();
    List<SecurityMenuDO> findOneById(int id);
    int insertOne(SecurityMenuDO securityMenuDO);
    int removeOne(int id);

    List<Long> listMenuIdsByStaffId(String staffId);
    List<Long> listMenuIdsByRoleId(String roleId);

    List<SecurityMenuDO> listByIds(List<Long> ids);
    Integer countChilds(String id);
}
