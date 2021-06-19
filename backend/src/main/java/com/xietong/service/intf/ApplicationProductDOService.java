package com.xietong.service.intf;

import java.util.Map;

public interface ApplicationProductDOService {
    boolean insert(Map<String, Object> params);

    boolean check(int applyNum, int actulNum);
}
