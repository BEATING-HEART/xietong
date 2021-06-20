package com.xietong.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xietong.model.entity.SecurityRoleDO;
import com.xietong.model.entity.StaffDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDOMapper {
    public List<StaffDO> findAll();
    public List<StaffDO> findOneById(String id);
    public int removeOne(String id);

    Boolean insertStaff(StaffDO staff);

    int logicallyRemove(String id);

    Boolean updateStaff(StaffDO staff);


//    List<SecurityRoleDO> list(QueryWrapper<SecurityRoleDO> id);

//    public int insertOne(String id);
}
