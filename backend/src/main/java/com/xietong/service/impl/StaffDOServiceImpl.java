package com.xietong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xietong.mapper.StaffDOMapper;
import com.xietong.model.entity.StaffDO;

//import com.xietong.model.entity.T.Test;
import com.xietong.service.intf.StaffDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffDOServiceImpl implements StaffDOService {
    @Autowired
    private StaffDOMapper staffDOMapper;

    @Override
    public List<StaffDO> findAll() {
        return staffDOMapper.findAll();
    }

    @Override
    public List<StaffDO> findOneById(String id) {
        return staffDOMapper.findOneById(id);
    }

    @Override
    public int removeOneById(String id) {
        return staffDOMapper.removeOne(id);
    }


//    @Override
//    public List<Test> unionSelect(int id) {
//        return testMapper.unionSelect(id);
//    }

}
