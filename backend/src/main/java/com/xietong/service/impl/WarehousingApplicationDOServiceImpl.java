package com.xietong.service.impl;

import com.xietong.constant.enums.ApplicationStatusEnum;
import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.mapper.ApplicationProductDOMapper;
import com.xietong.mapper.WarehousingApplicationDOMapper;
import com.xietong.model.entity.ApplicationProductDO;
import com.xietong.model.entity.WarehousingApplicationDO;
import com.xietong.service.intf.WarehousingApplicationDOService;
import com.xietong.utils.MyException;
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
        for(WarehousingApplicationDO application : listWareApp){
            int status = application.getStatus();
            String str = ApplicationStatusEnum.getNameByCode(status);
            application.setStatusStr(str);
        }
        return listWareApp;
    }

    @Override
    public WarehousingApplicationDO getById(long applicationId) {
        WarehousingApplicationDO application = warehousingApplicationDOMapper.getById(applicationId).get(0);
        int status = application.getStatus();
        String str = ApplicationStatusEnum.getNameByCode(status);
        application.setStatusStr(str);
        return application;
    }

    @Override @Transactional
    public boolean update(WarehousingApplicationDO application) {
            Long applicationId = application.getWarehousingApplicationId();
            application = warehousingApplicationDOMapper.getById(applicationId).get(0);
            int status = application.getStatus();
            if(status != ApplicationStatusEnum.FAIL.getCode() && status != ApplicationStatusEnum.CHECK_FAILED.getCode()){
                throw new MyException(ErrorCodeEnum.STATUS_LOCKED);
            }
            warehousingApplicationDOMapper.update(applicationId);
            applicationProductDOMapper.delete(applicationId);
            applicationProductDOMapper.insertList(applicationId, application.getApplicationProducts());

            return true;
    }


    @Override @Transactional // 事务
    public boolean insertWarehousingApplication(WarehousingApplicationDO application) {

        warehousingApplicationDOMapper.insert(application);
//        System.out.println(application.getWarehousingApplicationId());
        applicationProductDOMapper.insertList(application.getWarehousingApplicationId(), application.getApplicationProducts());
        return true;
    }

    @Override
    public Boolean check(Long applicationId, Boolean pass) {
        WarehousingApplicationDO application = warehousingApplicationDOMapper.getById(applicationId).get(0);
        int status = application.getStatus();
        if (status == ApplicationStatusEnum.UNHANDLED.getCode()){ // 如果不是待处理状态不能清点。
            if(pass)
                status = ApplicationStatusEnum.CHECKED.getCode();
            else
                status = ApplicationStatusEnum.CHECK_FAILED.getCode();
        } else {
            throw new MyException(ErrorCodeEnum.STATUS_LOCKED);
        }
        System.out.println("check"+status+"   "+application);
        return warehousingApplicationDOMapper.check(applicationId, status);
    }

    @Override @Transactional
    public boolean confirm(long warehousingApplicationId, boolean pass) {
        WarehousingApplicationDO application = warehousingApplicationDOMapper.getById(warehousingApplicationId).get(0);
        int status = application.getStatus();
        if (status == ApplicationStatusEnum.CHECKED.getCode()){ // 如果不是待审核状态就不能审核
            if(pass)
                status = ApplicationStatusEnum.PASS.getCode();
            else
                status = ApplicationStatusEnum.FAIL.getCode();
        } else {
            throw new MyException(ErrorCodeEnum.STATUS_LOCKED);
        }
        // 生成入库单

        return warehousingApplicationDOMapper.confirm(warehousingApplicationId, status);
    }
}
