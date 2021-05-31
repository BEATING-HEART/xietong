package com.xietong.controller;


import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.StaffDO;
import com.xietong.utils.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "欢迎来到软件系统设计spring boot项目";
    }

    @RequestMapping("/test")
    public ResponseDTO testResponse(){
        return new ResponseDTO(ErrorCodeEnum.UNSPECIFIED, new StaffDO("123","456","12346","135",true));
    }
}
