package com.xietong.service.impl;

import com.xietong.mapper.SecurityRoleMenuDOMapper;
import com.xietong.service.intf.SecurityRoleMenuDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Sunforge
 * @Date 2021-06-14 17:59
 */
@Service
public class SecurityRoleMenuDOServiceImpl implements SecurityRoleMenuDOService {
    @Autowired
    SecurityRoleMenuDOMapper securityRoleMenuDOMapper;


    @Override
    public Boolean deleteMenuFromRole(String menuId) {
        return securityRoleMenuDOMapper.deleteByMenuId(menuId);
    }
}
