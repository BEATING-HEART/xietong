package com.xietong.controller;

import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.service.intf.DeliveryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:49
 */
@Api(tags = {"发货管理 CJ"})
@RestController
@RequestMapping("/api/shipment")
public class ShipmentController {
    @Autowired
    private DeliveryService deliveryService;
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
    @PostMapping("/to-deliver")
    @ApiOperation(value = "发货(根据发货批次号shipmentId和staffId)")
    public ResponseDTO deliver(@RequestBody Map<String ,Object> params){
        try{
            try {
                if(deliveryService.deliver(params)){
                    System.out.println(params);
                    return ResponseDTO.success("发货成功，并已生成出库单和账单");
                }else {
                    return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"发货失败");
                }
            }catch (DataAccessException e){
                System.out.println(e);
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"发货失败");
            }

        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }
    }
    @GetMapping("/get-deliverSales")
    @ApiOperation(value = "获取需要发货的销售单及需要发货的批次")
    public ResponseDTO getDeliverSales(){
        try{
            try {
                    return  ResponseDTO.success(deliveryService.getDeliverSale());
            }catch (DataAccessException e){
                System.out.println(e);
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"获取数据失败");
            }

        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }
    }
}
