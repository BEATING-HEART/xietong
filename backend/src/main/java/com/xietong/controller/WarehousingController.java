package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-09 21:08
 */

@Api("入库单操作")
@RestController
@RequestMapping("/api/warehousing")
public class WarehousingController {
    // 入库单是对入库行为的一种记录，不直接修改。
    // 入库单是在入库申请被批准以后产生的。
    // 只有查询功能。
    // list
    // get
}
