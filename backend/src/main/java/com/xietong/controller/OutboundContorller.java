package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:49
 */
@Api(tags = {"出库单：是发货操作的记录 CJ"})
@RestController
@RequestMapping("/api/outbound")
public class OutboundContorller {
    // 出库单是发货操作的记录。不直接提供增删改接口

    // list 仓库经理，仓库人员
    // get  仓库经理，仓库人员
    @GetMapping("/list")
//    @PreAuthorize("hasRole('accounting')")
    public ResponseDTO listOutBounds(){
        return ResponseDTO.success("还没开发好");
    }

    @GetMapping("/get/{id}")
//    @PreAuthorize("hasRole('accounting')")
    public ResponseDTO getOutbound(@PathVariable(name = "id") Integer id){
        return ResponseDTO.success("还没开发好");
    }
}
