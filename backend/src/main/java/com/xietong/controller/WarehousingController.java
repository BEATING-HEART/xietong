package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Sunforge
 * @Date 2021-06-09 21:08
 */

@Api(tags = {"入库单 Andrew"})
@RestController
@RequestMapping("/api/warehousing")
public class WarehousingController {
    // 入库单是对入库行为的一种记录，不直接修改。
    // 入库单是在入库申请被批准以后产生的。
    // 只有查询功能。
    @GetMapping("/list")
    @ApiOperation("仓库人员内部查看入库单信息")
    @PreAuthorize("hasAnyRole({'warehousemanager','warehousestaff'})")
    public ResponseDTO listWarehousing(){
        return ResponseDTO.success("还没开发好");
    }

    @GetMapping("/get/{id}")
    @ApiOperation("仓库人员内部查看入库单信息")
    @PreAuthorize("hasAnyRole({'warehousemanager','warehousestaff'})")
    public ResponseDTO getWarehousing(@PathVariable(name = "id") Integer id){
        return ResponseDTO.success("还没开发好");
    }
    // list
    // get
}
