package com.xietong.service.impl;

import com.xietong.mapper.OutboundDOMapper;
import com.xietong.model.entity.receiveDO.OutboundNameDO;
import com.xietong.service.intf.OutboundDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OutboundDOServiceImpl implements OutboundDOService {
    @Autowired
    private OutboundDOMapper outboundDOMapper;
    @Override
    public List<OutboundNameDO> getBySaleId(int saleId) {
        return outboundDOMapper.getBySaleId(saleId);
    }

    @Override
    public List<OutboundNameDO> getByTime(Date time) {
        return outboundDOMapper.getByTime(time);
    }
}
