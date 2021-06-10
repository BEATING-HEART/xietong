package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:45
 */
@Api("客户操作")
@RestController
@RequestMapping("/api/customer")
public class CustomerContorller {
    // insert 销售员添加
    // 不提供删除权限。只能逻辑删除，即用update将可用性变为false
    // update 销售员权限，销售经理权限
    // list   销售员权限，销售经理权限
    // get    销售员权限，销售经理权限
}
