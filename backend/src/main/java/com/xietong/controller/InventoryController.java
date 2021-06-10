package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-09 20:58
 */
@Api("库存操作")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    // 库存不可接口修改。只可查询
    // list 普通员工权限
    // get  普通员工权限
}
