package com.xietong.service.impl;

import com.xietong.mapper.ApplicationProductDOMapper;
import com.xietong.mapper.WarehousingApplicationDOMapper;
import com.xietong.model.entity.ApplicationProductDO;
import com.xietong.model.entity.WarehousingApplicationDO;
import com.xietong.service.intf.WarehousingApplicationDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service

public class WarehousingApplicationDOServiceImpl implements WarehousingApplicationDOService {
    @Autowired
    private WarehousingApplicationDOMapper warehousingApplicationDOMapper;
    @Autowired
    private ApplicationProductDOMapper applicationProductDOMapper;


    @Override @Transactional // 事务
    public boolean deleteWarehousingApplication(long applicationId) {
        // 外键约束要先删除关系表
        applicationProductDOMapper.delete(applicationId);
        warehousingApplicationDOMapper.delete(applicationId);

        return true;
    }

    @Override
    public List<WarehousingApplicationDO> list() {
        List<WarehousingApplicationDO> listWareApp = warehousingApplicationDOMapper.listApplication();
        System.out.println(listWareApp);
        return listWareApp;
    }

    @Override
    public WarehousingApplicationDO getById(long applicationId) {
        return warehousingApplicationDOMapper.getById(applicationId).get(0);
    }

    @Override @Transactional
    public boolean update(WarehousingApplicationDO application) {
            Long applicationId = application.getWarehousingApplicationId();
            applicationProductDOMapper.delete(applicationId);
            applicationProductDOMapper.insertList(applicationId, application.getApplicationProducts());
            return true;
    }

    @Override
    public boolean confirm(long warehousingApplicationId, int status) {
        if(warehousingApplicationDOMapper.confirm(warehousingApplicationId,status))
            return true;
        else
        return false;
    }

    @Override @Transactional // 事务
    public boolean insertWarehousingApplication(WarehousingApplicationDO application) {

        warehousingApplicationDOMapper.insert(application);
        System.out.println(application.getWarehousingApplicationId());
        applicationProductDOMapper.insertList(application.getWarehousingApplicationId(), application.getApplicationProducts());
        return true;
    }
}
