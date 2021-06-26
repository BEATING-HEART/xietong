package com.xietong.service.intf;

import com.xietong.model.entity.ApplicationProductDO;

import java.util.List;
import java.util.Map;

public interface ApplicationProductDOService {
    boolean insert(Map<String, Object> params);

//    boolean check(int applyNum, int actulNum);

    List<ApplicationProductDO> listByApplicationId(Long id);


}
