package com.xietong.controller;

import com.xietong.model.entity.CustomerDO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:45
 */
@Api("客户操作")
@RestController
@RequestMapping("/api/customer")
public class CustomerContorller {

    @PostMapping("/insertCustomer") //增加客户
    public List<CustomerDO> insertCustomer(){
        return  insertCustomer(new CustomerDO());
    }

    @PostMapping("/deleteCustomer")//删除客户
    public int deleteCustomer(@PathVariable(name = "id") String id){
        return  deleteCustomer(id);
    }

    @GetMapping("/listCustomer")//显示所有客户
    public void listCustomer(){
        listCustomer();
    }

    @GetMapping("/getCustomerById")//查找客户 id
    public List<CustomerDO> getCustomer(@PathVariable(name = "id") String id){
        return  getCustomer(id);
    }

    @PostMapping("/updateCustomer")//更新客户
    public int updateCustomer(@PathVariable(name = "id") String id){
        return  updateCustomer(id);
    }
    // insert 销售员添加
    // 不提供删除权限。只能逻辑删除，即用update将可用性变为false
    // update 销售员权限，销售经理权限
    // list   销售员权限，销售经理权限
    // get    销售员权限，销售经理权限
}
