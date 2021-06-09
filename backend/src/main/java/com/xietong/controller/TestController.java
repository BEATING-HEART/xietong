package com.xietong.controller;


import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.StaffDO;
//import com.xietong.model.entity.T.Test;
import com.xietong.service.intf.StaffDOService;
import com.xietong.utils.MyException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api("测试类")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StaffDOService staffDOService;
    @GetMapping("/hello")
    public String hello(){
        return "欢迎来到软件系统设计spring boot项目";
    }

    @GetMapping("/test")
    public ResponseDTO testResponse(){
        return ResponseDTO.success(new StaffDO("123","456","12346","135",true,1));
    }
    @GetMapping("/findAll")
    public List<StaffDO> findAll(){
        return staffDOService.findAll();
    }
    @GetMapping("/findOne/{id}")
    public List<StaffDO> findOne(@PathVariable(name = "id") String id){
        return staffDOService.findOneById(id);
    }
    @GetMapping("/removeOne/{id}")
    public int removeOne(@PathVariable(name = "id") String id){
        return staffDOService.removeOneById(id);
    }
    @PostMapping("/post-by-url-param")
    public ResponseDTO postUrlParam(@RequestParam Map<String, Object> params){
        // 也可以使用Bean对象来接收。
        System.out.println(params.toString());
        return ResponseDTO.success("成功接收路径请求参数",params);
    }
    @PostMapping("/post-by-json-param")
    public ResponseDTO postJson(@RequestBody Map<String, Object> params){
        // 也可以使用Bean对象来接收。
        return ResponseDTO.success("成功接收JSON参数",params);
    }

//    @RequestMapping("/findTest/{id}")
//    public ResponseDTO findTest(@PathVariable(name = "id") int id){
////        return staffDOService.unionSelect(id);
//        return ResponseDTO.success(staffDOService.unionSelect(id));
//
//    }
}


