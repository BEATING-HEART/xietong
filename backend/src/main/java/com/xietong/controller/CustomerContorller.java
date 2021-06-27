package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.CustomerDO;
import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.service.intf.CustomerDOService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
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


    @PostMapping("/insert") @Transactional//增加客户
    public ResponseDTO insertCustomer(@RequestBody CustomerDO customerDO){
        boolean sta=customerDOService.insert(customerDO);
        if (sta)
            return ResponseDTO.success("添加客户成功");
        else return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

    @GetMapping("/list")//显示所有客户
    public ResponseDTO listCustomer(){

        return ResponseDTO.success("成功显示",customerDOService.list());
    }

    @GetMapping("/get/{customerId}")//查找客户 id
    public ResponseDTO getCustomer(@PathVariable(name = "customerId") int id){
        return  ResponseDTO.success(customerDOService.getById(id));
    }

    @PostMapping("/update")//更新客户
    public ResponseDTO updateCustomer(@RequestBody CustomerDO customerDO){
        if(customerDOService.update(customerDO))
            return ResponseDTO.success("更新客户成功");
        else
        return  ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

    @PostMapping("/delete/{customerId}") //逻辑删除
    public ResponseDTO updateCustomerStatus(@PathVariable(name = "customerId") int id){
        if(customerDOService.updateStatus(id,0))
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
