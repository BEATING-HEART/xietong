package com.xietong.service.intf;

import com.xietong.model.entity.WarehousingApplicationDO;

import java.util.List;
import java.util.Map;

public interface WarehousingApplicationDOService {

    boolean deleteWarehousingApplication(long warehousingApplicationId);
    boolean insertWarehousingApplication(WarehousingApplicationDO application);


    List<WarehousingApplicationDO> list();

    WarehousingApplicationDO getById(long warehousingApplicationId);

    boolean update(WarehousingApplicationDO application);

    boolean confirm(long warehousingApplicationId, boolean pass);


    Boolean check(Long applicationId, Boolean pass);
}
