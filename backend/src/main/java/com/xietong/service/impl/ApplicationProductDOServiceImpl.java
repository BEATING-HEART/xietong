package com.xietong.service.impl;

import com.xietong.mapper.ApplicationProductDOMapper;
import com.xietong.service.intf.ApplicationProductDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service

public class ApplicationProductDOServiceImpl implements ApplicationProductDOService {
    @Autowired
    private ApplicationProductDOMapper applicationProductDOMapper;


    @Override
    public boolean insert(Map<String, Object> params) {
        return false;
    }

    @Override
    public boolean check(int applyNum, int actulNum) {
        return false;
    }
}
