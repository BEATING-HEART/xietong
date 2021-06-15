package com.xietong.service.impl;

import com.xietong.mapper.SecurityMenuDOMapper;
import com.xietong.model.dto.MenuDTO;
import com.xietong.model.entity.SecurityMenuDO;
import com.xietong.model.entity.StaffDO;
import com.xietong.service.intf.SecurityMenuDOService;


import com.xietong.service.intf.StaffDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityMenuDOServiceImpl implements SecurityMenuDOService {
    @Autowired
    private SecurityMenuDOMapper securityMenuDOMapper;

    @Autowired
    private StaffDOService staffDOService;

    @Override
    public List<SecurityMenuDO> findAll() {
        return securityMenuDOMapper.findAll();
    }

    @Override
    public List<SecurityMenuDO> findOneById(String id) {
        return securityMenuDOMapper.findOneById(Integer.parseInt(id));
    }

    @Override
    public int insertOne(SecurityMenuDO securityMenuDO) {
        return securityMenuDOMapper.insertOne(securityMenuDO);
    }

    @Override
    public int removeOne(String id) {
        return securityMenuDOMapper.removeOne(Integer.parseInt(id));
    }

    @Override
    public List<Long> listMenuIdsByStaffId(String staffId) {
        return securityMenuDOMapper.listMenuIdsByStaffId(staffId);
    }

    @Override
    public List<Long> listMenuIdsByRoleId(String roleId){
        return securityMenuDOMapper.listMenuIdsByRoleId(roleId);
    }

    @Override
    public List<SecurityMenuDO> listByIds(List<Long> ids) {
        return securityMenuDOMapper.listByIds(ids);
    }

    @Override
    public List<MenuDTO> getCurStaffNav() {
        String staffId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        StaffDO staff = staffDOService.findOneById(staffId).get(0);
//        System.out.println(staffId);
        List<Long> menuIds = this.listMenuIdsByStaffId(staffId);
        List<SecurityMenuDO> menus = this.listByIds(menuIds);
        List<SecurityMenuDO> menuTree = buildMenuTree(menus);

        return convertMenuTreeToMenuDTO(menuTree);
    }

    @Override
    public List<SecurityMenuDO> listAsTree() {
        List<SecurityMenuDO> menus = this.findAll();
        return buildMenuTree(menus);
    }

    @Override
    public Boolean hasChild(String id) {
        Integer count = securityMenuDOMapper.countChilds(id);
        return count > 0;
    }

    private List<MenuDTO> convertMenuTreeToMenuDTO(List<SecurityMenuDO> menuTree) {
        List<MenuDTO> menuDTOS = new ArrayList<>();
        menuTree.forEach(e -> {
            MenuDTO dto = new MenuDTO();
            dto.setId(e.getId());
            dto.setCode(e.getPerms());
            dto.setTitle(e.getName());
            dto.setComponent(e.getComponent());
            dto.setPath(e.getPath());

            if(e.getChildren().size() > 0){
                // 子节点递归。
                dto.setChildren(convertMenuTreeToMenuDTO(e.getChildren()));
            }
            menuDTOS.add(dto);
        });
        return menuDTOS;
    }

    private List<SecurityMenuDO> buildMenuTree(List<SecurityMenuDO> menus) {
        List<SecurityMenuDO> menuTree = new ArrayList<>();
        for(SecurityMenuDO menu : menus){
            for(SecurityMenuDO e : menus){
                if(menu.getId() == e.getParentId()){
                    menu.getChildren().add(e);
                }
            }
            if(menu.getParentId() == 0L){
                menuTree.add(menu);
            }
        }
        return menuTree;
    }
}
