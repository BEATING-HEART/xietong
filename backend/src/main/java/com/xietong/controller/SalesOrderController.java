package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:43
 */
@Api("销售销售单操作")
@RestController
@RequestMapping("/api/sale")
public class SalesOrderController {
    // insert  销售人员权限 【insert也填写order-product，shipment，shipment-product】
    // delete  销售人员权限（审核通过前可以删除）
    // update  销售人员权限（审核通过前可以修改）【update也修改order-product，shipment， shipemnt-product】
    // list    销售人员/销售经理 【联表查询，查order-product 。。。】
    // get     销售人员/销售经理 【联表查询，查order-product 。。。】
    // confirm 销售经理审核。 分 pass 和 非pass两种 【具体QQ上交流】 【审核通过则修改状态】
}
