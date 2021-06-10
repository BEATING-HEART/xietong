package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:51
 */
@Api("财务赊购操作")
@RestController
@RequestMapping("/api/credit")
public class CreditPurchaseController {
    // 不提供insert接口，insert在仓库出库的时候添加

    // 根据时间，公司等信息查找，【路径QQ上细说】
    // list 只有list
    // get  只有get
}
