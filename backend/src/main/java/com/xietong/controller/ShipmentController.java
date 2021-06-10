package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:49
 */
@Api("仓库发货单操作")
@RestController
@RequestMapping("/api/shipment")
public class ShipmentController {
    // 不提供增删改权限，是销售单填写时候加上的。

    // list    销售人员/销售经理/仓库人员/仓库经理 【联表查询】
    // get     销售人员/销售经理/仓库人员/仓库经理 【联表查询】

    // toDeliver 仓库操作发货。
}
