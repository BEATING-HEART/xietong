package com.xietong.controller.temp;

import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.SecurityMenuDO;

import com.xietong.service.intf.SecurityMenuDOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@RestController
@RequestMapping("/t")

public class SecurityMenuDOController {
    @Autowired
    private SecurityMenuDOService securityMenuDOService;
    @RequestMapping("/findAll")
    public List<SecurityMenuDO> findAll(){
        return securityMenuDOService.findAll();
    }
    @RequestMapping("/findOneById/{id}")
    public List<SecurityMenuDO> findOneById(@PathVariable(name = "id") String id){
        return  securityMenuDOService.findOneById(id);
    }
    @RequestMapping("/RemoveOne/{id}")
    public int removeOne(@PathVariable(name = "id") String id){
        return securityMenuDOService.removeOne(id);
    }
    @RequestMapping("/insertOne")
    public int insertOne(){
        return securityMenuDOService.insertOne(new SecurityMenuDO((long)123,(long)456,"12346","135","1","1",1,"1",1,1));
    }
}
