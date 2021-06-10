package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-09 21:02
 */
@Api("入库申请单操作")
@RestController
@RequestMapping("/api/application")
public class WarehousingApplicationController {
    // insert  车间人员权限 【insert也填写application-product】
    // delete  车间人员权限（审核通过前可以删除）
    // update  车间人员权限（审核通过前可以修改，若修改则需要仓库管理员重新确认）【update也修改application-product】
    // list    车间人员/仓库人员/仓库经理 【联表查询】
    // get     车间人员/仓库人员/仓库经理 【联表查询 application-product】
    // check   仓库人员清点。 分 pass 和 非pass两种 【具体QQ上交流】
    // confirm 仓库经理审核。 分 pass 和 非pass两种 【具体QQ上交流】 【审核通过那修改inventory和warehousing】
}
