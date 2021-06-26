package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:51
 */
@Api(tags = {"账单：发一批货产生一个账单 CJ"})
@RestController
@RequestMapping("/api/credit")
public class CreditPurchaseController {
    // 不提供insert接口，insert在仓库出库的时候添加
    // 根据时间，公司等信息查找
    // list 只有list
    // get  只有get
//    @GetMapping("/list")
//    @PreAuthorize("hasRole('accounting')")
//    public ResponseDTO listCredits(){
//        return ResponseDTO.success("还没开发好");
//    }
//
//    @GetMapping("/get/{id}")
//    @PreAuthorize("hasRole('accounting')")
//    public ResponseDTO getCredit(@PathVariable(name = "id") Integer id){
//        return ResponseDTO.success("还没开发好");
//    }
    // 先实现不设约束的
    // 还有 get by time by company
}
