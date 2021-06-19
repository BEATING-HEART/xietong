package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:49
 */
@Api(tags = {"发货管理 CJ"})
@RestController
@RequestMapping("/api/shipment")
public class ShipmentController {
    // 不提供增删改权限，是销售单填写时候加上的。

    // list    销售人员/销售经理/仓库人员/仓库经理 【联表查询】
    // get     销售人员/销售经理/仓库人员/仓库经理 【联表查询】

    @GetMapping("/list")
    public ResponseDTO listShipments(){
        return ResponseDTO.success("还没开发好");
    }

    @GetMapping("/get/{id}")

    public ResponseDTO getShipment(@PathVariable(name = "id") Integer id){
        return ResponseDTO.success("还没开发好");
    }

    // toDeliver 仓库操作发货。
    @GetMapping("/to-deliver/{id}")
    public ResponseDTO toDeliver(@PathVariable(name = "id") Integer id){
        return ResponseDTO.success("还没开发好");
    }
}
