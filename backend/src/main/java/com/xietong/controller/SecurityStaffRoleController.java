package com.xietong.controller;

import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.SecurityRoleDO;
import com.xietong.model.entity.SecurityStaffRoleDO;
import com.xietong.service.intf.SecurityRoleDOService;
import com.xietong.service.intf.SecurityStaffRoleDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/securityStaffRole")
public class SecurityStaffRoleController {
    @Autowired
    private SecurityStaffRoleDOService securityStaffRoleDOService;
    @RequestMapping("/insert")
    public int insert(){
        int a=securityStaffRoleDOService.insert(new SecurityStaffRoleDO((long) 1,"1",(long) 1));
        return a;
    }
    @RequestMapping("/findAll")
    public ResponseDTO findAll(){
        return ResponseDTO.success(securityStaffRoleDOService.findAll());
    }
    @RequestMapping("/findOneById/{id}")
    public ResponseDTO findOneById(@PathVariable(name = "id") Long id){
        return ResponseDTO.success(securityStaffRoleDOService.findOneById(id));
    }
    @RequestMapping("/removeOne/{id}")
    public ResponseDTO removeOne(@PathVariable(name = "id") Long id){
        return ResponseDTO.success(securityStaffRoleDOService.removeOne(id));
    }
}
