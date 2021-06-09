package com.xietong.controller;

import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.SecurityRoleDO;
import com.xietong.service.intf.SecurityRoleDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@RestController
@RequestMapping("/api/user/v1")
public class SecurityRoleController {
    @Autowired
    private SecurityRoleDOService securityRoleDOService;
    @RequestMapping("/insert")
    public int insert(){
        int a=securityRoleDOService.insert(new SecurityRoleDO((long) 1,"小明","12","ss",1));
        return a;
    }
    @RequestMapping("/findAll")
    public ResponseDTO findAll(){
        return ResponseDTO.success(securityRoleDOService.findAll());
    }
    @RequestMapping("/findOneById/{id}")
    public ResponseDTO findOneById(@PathVariable(name = "id") Long id){
        return ResponseDTO.success(securityRoleDOService.findOneById(id));
    }
    @RequestMapping("/removeOne/{id}")
    public ResponseDTO removeOne(@PathVariable(name = "id") Long id){
        return ResponseDTO.success(securityRoleDOService.removeOne(id));
    }

}
