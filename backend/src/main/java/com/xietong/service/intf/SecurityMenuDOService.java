package com.xietong.service.intf;

import com.xietong.model.entity.SecurityMenuDO;


import java.util.List;

public interface SecurityMenuDOService {
    public List<SecurityMenuDO> findAll();
    public List<SecurityMenuDO> findOneById(String id);
    public int insertOne(SecurityMenuDO securityMenuDO);
    public int removeOne(String id);

}
