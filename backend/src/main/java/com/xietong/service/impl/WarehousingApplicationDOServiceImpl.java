package com.xietong.service.impl;

import com.xietong.mapper.WarehousingApplicationDOMapper;
import com.xietong.model.entity.WarehousingApplicationDO;
import com.xietong.service.intf.WarehousingApplicationDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service

public class WarehousingApplicationDOServiceImpl implements WarehousingApplicationDOService {
    @Autowired
    private WarehousingApplicationDOMapper warehousingApplicationDOMapper;

    @Override
    public boolean insert(Map<String, Object> params) {
        WarehousingApplicationDO warehousingApplicationDO=new WarehousingApplicationDO((Long) params.get("warehousingApplicationId"),params.get("staffId").toString(),new Date(),(int)params.get("workshopId"),(int)params.get("status"));
        if(warehousingApplicationDOMapper.insert(warehousingApplicationDO))
            return true;
        else
        return false;
    }

    @Override
    public boolean deleteWarehousingApplication(long warehousingApplicationId) {
        if(warehousingApplicationDOMapper.delete(warehousingApplicationId))
        return true;
        else return false;
    }

    @Override
    public List<WarehousingApplicationDO> list() {
        List<WarehousingApplicationDO> listWareApp=warehousingApplicationDOMapper.list();
        return listWareApp;
    }

    @Override
    public List<WarehousingApplicationDO> getById(long warehousingApplicationId) {
        List<WarehousingApplicationDO> listWareApp=warehousingApplicationDOMapper.getById(warehousingApplicationId);
        return listWareApp;
    }

    @Override
    public boolean update(Map<String, Object> params) {
        WarehousingApplicationDO warehousingApplicationDO=new WarehousingApplicationDO((Long) params.get("warehousingApplicationId"),params.get("staffId").toString(),new Date(),(int)params.get("workshopId"),(int)params.get("status"));
        if(warehousingApplicationDOMapper.update(warehousingApplicationDO))
            return true;
        else
        return false;
    }

    @Override
    public boolean confirm(long warehousingApplicationId, int status) {
        if(warehousingApplicationDOMapper.confirm(warehousingApplicationId,status))
            return true;
        else
        return false;
    }
}
