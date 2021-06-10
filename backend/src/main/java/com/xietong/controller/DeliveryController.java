package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:50
 */
@Api("仓库发货单操作")
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    // 不提供增删改接口 发货单是对发货操作的记录。

    // list   仓库人员，仓库经理，销售人员，销售经理
    // get    仓库人员，仓库经理，销售人员，销售经理
}
