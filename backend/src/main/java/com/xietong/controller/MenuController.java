package com.xietong.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.SecurityMenuDO;
import com.xietong.model.entity.SecurityRoleDO;
import com.xietong.model.entity.SecurityRoleMenuDO;
import com.xietong.service.intf.SecurityMenuDOService;
import com.xietong.service.intf.SecurityRoleMenuDOService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Sunforge
 * @Date 2021-06-09 20:54
 */
@Api("权限菜单操作")
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    SecurityMenuDOService securityMenuDOService;

    @Autowired
    SecurityRoleMenuDOService securityRoleMenuDOService;
    

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('menu:list')") // 权限控制通了
    public ResponseDTO getInfo(@PathVariable(name = "id") String id){
        return ResponseDTO.success(securityMenuDOService.findOneById(id));
    }

    @GetMapping("/list")
    public ResponseDTO listMenu(){
        List<SecurityMenuDO> menus = securityMenuDOService.listAsTree();
        return ResponseDTO.success(menus);
    }

    @PostMapping ("/insert")
    public ResponseDTO insertMenu(@Validated @RequestBody SecurityMenuDO menu){
        menu.setStatus(true);
        securityMenuDOService.insertOne(menu);
        return ResponseDTO.success("插入成功", menu);
    }


    @PostMapping ("/update")
    /**
     * 没有update方法。
     */
    public ResponseDTO updateMenu(@Validated @RequestBody SecurityMenuDO menu){

        // 清除缓存

        return ResponseDTO.fail("后端还未实现update方法");
    }

    @PostMapping ("/delete/{id}")
    public ResponseDTO deleteMenu(@PathVariable(name = "id") String menuId){

        if( securityMenuDOService.hasChild(menuId) ){
            return ResponseDTO.fail("请先删除子菜单");
        }
        //  删除缓存[暂无]
        securityMenuDOService.removeOne(menuId);
        securityRoleMenuDOService.deleteMenuFromRole(menuId);
        return ResponseDTO.success(null);
    }


    // insert 都是管理员权限
    // delete
    // update
    // list
    // get
}
