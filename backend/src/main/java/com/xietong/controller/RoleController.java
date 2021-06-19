package com.xietong.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xietong.constant.consist.GlobalConsist;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.SecurityMenuDO;
import com.xietong.model.entity.SecurityRoleDO;
import com.xietong.model.entity.SecurityRoleMenuDO;
import com.xietong.service.intf.SecurityMenuDOService;
import com.xietong.service.intf.SecurityRoleDOService;
import com.xietong.service.intf.SecurityRoleMenuDOService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Author Sunforge
 * @Date 2021-06-09 20:52
 */
@Api("管理员角色操作")
@ApiIgnore
@RestController
@RequestMapping("/api/role")
@PreAuthorize("hasRole('admin')")
public class RoleController {

    @Autowired
    SecurityRoleDOService securityRoleDOService;

    @Autowired
    SecurityRoleMenuDOService securityRoleMenuDOService;

    @Autowired
    SecurityMenuDOService securityMenuDOService;

    @GetMapping("/get/{id}")
    public ResponseDTO getRoleDetail(@PathVariable(name = "id") Long id){
        SecurityRoleDO role = securityRoleDOService.findOneById(id).get(0);
        List<Long> roleMenus = securityMenuDOService.listMenuIdsByRoleId(id.toString());
        role.setMenuIds(roleMenus);
        return ResponseDTO.success(role);
    }

    @GetMapping("/list/{pageId}")
    public ResponseDTO listRoles(@PathVariable(name = "pageId") int pageId){
//        Page<SecurityRoleDO> rolePage = securityRoleDOService.page(new Page(pageId, GlobalConsist.PAGE_SIZE))
        return ResponseDTO.success(null);
    }

    @PostMapping("/insert")
    public ResponseDTO insertRole(@Validated @RequestBody SecurityRoleDO role){
        return ResponseDTO.success(null);
    }

    @PostMapping("/update")
    public ResponseDTO updateRole(@Validated @RequestBody SecurityRoleDO role){
        return ResponseDTO.success(null);
    }

    @GetMapping("/delete")
    public ResponseDTO deleteRoles(@RequestBody long[] ids){
        return ResponseDTO.success(null);
    }

    @GetMapping("/perm/{roleId}")
    public ResponseDTO permRole(@PathVariable(name = "roleId") long roleId, @RequestBody long[] menuIds){
        return ResponseDTO.success(null);
    }


    // insert 都是管理员权限
    // delete
    // update
    // list
    // get
}
