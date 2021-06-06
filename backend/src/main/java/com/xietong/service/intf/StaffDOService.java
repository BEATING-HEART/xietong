package com.xietong.service.intf;

import com.xietong.model.entity.StaffDO;
import com.xietong.model.entity.T.Test;

import java.util.List;

public interface StaffDOService {
    public List<StaffDO> findAll();
    public List<StaffDO> findOneById(String id);
    public int removeOneById(String id);
    public List<Test> unionSelect(int id);
}
