package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:49
 */
@Api("仓库出库单操作")
@RestController
@RequestMapping("/api/outbound")
public class OutboundContorller {
    // 出库单是发货操作的记录。不直接提供增删改接口

    // list 仓库经理，仓库人员
    // get  仓库经理，仓库人员
}
