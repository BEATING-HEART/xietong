package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.CustomerDO;
import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.service.intf.CustomerDOService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:45
 */
@Api(tags = {"客户管理 Andrew"})
//@ApiIgnore
@RestController
@RequestMapping("/api/customer")
public class CustomerContorller {

    @Autowired
    CustomerDOService customerDOService;


    @PostMapping("/insertCustomer") //增加客户
    public ResponseDTO insertCustomer(@RequestBody CustomerDO customerDO){
        boolean sta=customerDOService.insert(customerDO);
        if (sta)
            return ResponseDTO.success("添加客户成功");
        else return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }
/*
    @PostMapping("/deleteCustomer")//删除客户
    // public ResponseDTO deleteCustomer(@PathVariable(name = "id") String id){
    //     return  ResponseDTO.success("未完成开发");
    public ResponseDTO deleteCustomer(@RequestBody Map<String ,Object> params){
        if(customerDOService.delete((int)params.get("customerId")))
            return ResponseDTO.success("删除客户成功");
        else
        return  ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

 */

    @GetMapping("/listCustomer")//显示所有客户
    public ResponseDTO listCustomer(){

        return ResponseDTO.success("成功显示",customerDOService.list());
    }

    @GetMapping("/getCustomerById")//查找客户 id
    public ResponseDTO getCustomer(@RequestBody Map<String ,Object> params){

        return  ResponseDTO.success(customerDOService.getById((int)params.get("customerId")));
    }

    @PostMapping("/updateCustomer")//更新客户

    public ResponseDTO updateCustomer(@RequestBody CustomerDO customerDO){
        if(customerDOService.update(customerDO))
            return ResponseDTO.success("更新客户成功");
        else
        return  ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

    @PostMapping("/updateCustomerStatus")//更新客户 逻辑删除
    public ResponseDTO updateCustomerStatus(@RequestBody Map<String ,Object> params){
        if(customerDOService.updateStatus((int)params.get("customerId"),(int)params.get("effective")))
            return ResponseDTO.success("更新客户成功");
        else
            return  ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

    // insert 销售员添加
    // 不提供删除权限。只能逻辑删除，即用update将可用性变为false
    // update 销售员权限，销售经理权限
    // list   销售员权限，销售经理权限
    // get    销售员权限，销售经理权限
}
