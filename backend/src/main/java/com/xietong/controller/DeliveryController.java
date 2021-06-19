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
 * @Date 2021-06-10 10:50
 */
@Api(tags = {"发货单：是发货操作的记录 CJ"})
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    // 不提供增删改接口 发货单是对发货操作的记录。
    // list   仓库人员，仓库经理，销售人员，销售经理
    // get    仓库人员，仓库经理，销售人员，销售经理
    @GetMapping("/list")
//    @PreAuthorize("hasRole('accounting')")
    public ResponseDTO listDeliveries(){
        return ResponseDTO.success("还没开发好");
    }

    @GetMapping("/get/{id}")
//    @PreAuthorize("hasRole('accounting')")
    public ResponseDTO getDelivery(@PathVariable(name = "id") Integer id){
        return ResponseDTO.success("还没开发好");
    }
    // 先实现不设约束的 // 从shipment表中去拿，拿那些发货了的

}
