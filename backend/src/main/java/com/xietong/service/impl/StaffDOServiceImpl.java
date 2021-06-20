package com.xietong.service.impl;

import com.xietong.mapper.StaffDOMapper;
import com.xietong.model.entity.SecurityMenuDO;
import com.xietong.model.entity.SecurityRoleDO;
import com.xietong.model.entity.StaffDO;

//import com.xietong.model.entity.T.Test;
import com.xietong.service.intf.SecurityMenuDOService;
import com.xietong.service.intf.SecurityRoleDOService;
import com.xietong.service.intf.StaffDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffDOServiceImpl implements StaffDOService {
    @Autowired
    private StaffDOMapper staffDOMapper;

    @Autowired
    private SecurityRoleDOService securityRoleDOService;

    @Autowired
    private SecurityMenuDOService securityMenuDOService;



    public Boolean insertStaff(StaffDO staff){
        return staffDOMapper.insertStaff(staff);
    }

    @Override
    public Boolean updateStaff(StaffDO staff) {
        return staffDOMapper.updateStaff(staff);
    }

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

    @Override
    public int logicallyDeleteById(String id) {
        return staffDOMapper.logicallyRemove(id);
    }

    @Override
    public String getUserAuthorityInfo(String staffId){
        String authority = "";
        // 获取角色  v44, 15:30
        List<SecurityRoleDO> roles = securityRoleDOService.listRolesByStaffId(staffId);
        if(roles.size() > 0){
            String roleIds =  roles.stream().map(r -> "ROLE_" + r.getCode()).collect(Collectors.joining(","));
            authority += roleIds;
        }

        List<Long> menuIds = securityMenuDOService.listMenuIdsByStaffId(staffId);
//        System.out.println(menuIds.toString());
        if(menuIds.size() > 0){
            List<SecurityMenuDO> menus = securityMenuDOService.listByIds(menuIds);
            String menuPerms = menus.stream().map(m -> m.getPerms()).collect(Collectors.joining(","));
            authority = authority + "," + menuPerms;
        }


//        securityRoleDOService.list( );
        // 获取菜单操作权限
        return authority;
    }


//    @Override
//    public List<Test> unionSelect(int id) {
//        return testMapper.unionSelect(id);
//    }

}
