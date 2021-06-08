package com.xietong.controller;


import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.StaffDO;
//import com.xietong.model.entity.T.Test;
import com.xietong.service.intf.StaffDOService;
import com.xietong.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StaffDOService staffDOService;
    @RequestMapping("/hello")
    public String hello(){
        return "欢迎来到软件系统设计spring boot项目";
    }

    @RequestMapping("/test")
    public ResponseDTO testResponse(){
        return ResponseDTO.success(new StaffDO("123","456","12346","135",true,1));
    }
    @RequestMapping("/findAll")
    public List<StaffDO> findAll(){
        return staffDOService.findAll();
    }
    @RequestMapping("/findOne/{id}")
    public List<StaffDO> findOne(@PathVariable(name = "id") String id){
        return staffDOService.findOneById(id);
    }
    @RequestMapping("/removeOne/{id}")
    public int removeOne(@PathVariable(name = "id") String id){
        return staffDOService.removeOneById(id);
    }
//    @RequestMapping("/findTest/{id}")
//    public ResponseDTO findTest(@PathVariable(name = "id") int id){
////        return staffDOService.unionSelect(id);
//        return ResponseDTO.success(staffDOService.unionSelect(id));
//
//    }
}


