package com.xietong.service.intf;

import com.xietong.model.entity.WarehousingApplicationDO;

import java.util.List;
import java.util.Map;

public interface WarehousingApplicationDOService {

    boolean insert(Map<String, Object> params);

    boolean deleteWarehousingApplication(long warehousingApplicationId);

    List<WarehousingApplicationDO> list();

    List<WarehousingApplicationDO> getById(long warehousingApplicationId);

    boolean update(Map<String, Object> params);

    boolean confirm(long warehousingApplicationId, int status);
}
