package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-09 20:55
 */
@Api("产品操作")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    // insert 管理员权限
    // delete 管理员权限
    // update 管理员权限
    // list   普通员工权限
    // get    普通员工权限
}
