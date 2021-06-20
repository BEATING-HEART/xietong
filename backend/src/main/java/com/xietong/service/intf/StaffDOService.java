package com.xietong.service.intf;

import com.xietong.model.dto.StaffDTO;
import com.xietong.model.entity.StaffDO;


import java.util.List;

public interface StaffDOService {
    public List<StaffDO> findAll();
    public List<StaffDO> findOneById(String id);
    public int removeOneById(String id);
    int logicallyDeleteById(String id);

    String getUserAuthorityInfo(String staffId);

    Boolean insertStaff(StaffDO staff);

    Boolean updateStaff(StaffDO staff);
//    public List<Test> unionSelect(int id);
}
