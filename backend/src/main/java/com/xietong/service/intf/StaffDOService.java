package com.xietong.service.intf;

import com.xietong.model.entity.StaffDO;

import java.util.List;

public interface StaffDOService {
    public List<StaffDO> findAll();
    public List<StaffDO> findOneById(String id);
    public int removeOneById(String id);
}
