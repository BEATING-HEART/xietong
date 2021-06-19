package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.CustomerDO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:45
 */
@Api(tags = {"客户管理 Andrew"})
//@ApiIgnore
@RestController
@RequestMapping("/api/customer")
public class CustomerContorller {

    @PostMapping("/insertCustomer") //增加客户
    public ResponseDTO insertCustomer(){
        return  ResponseDTO.success("未完成开发");
    }

    @PostMapping("/deleteCustomer")//删除客户
    public ResponseDTO deleteCustomer(@PathVariable(name = "id") String id){
        return  ResponseDTO.success("未完成开发");
    }

    @GetMapping("/listCustomer")//显示所有客户
    public ResponseDTO listCustomer(){
        return  ResponseDTO.success("未完成开发");
    }

    @GetMapping("/getCustomerById")//查找客户 id
    public ResponseDTO getCustomer(@PathVariable(name = "id") String id){
        return  ResponseDTO.success("未完成开发");
    }

    @PostMapping("/updateCustomer")//更新客户
    public ResponseDTO updateCustomer(@PathVariable(name = "id") String id){
        return  ResponseDTO.success("未完成开发");
    }
    // insert 销售员添加
    // 不提供删除权限。只能逻辑删除，即用update将可用性变为false
    // update 销售员权限，销售经理权限
    // list   销售员权限，销售经理权限
    // get    销售员权限，销售经理权限
}
