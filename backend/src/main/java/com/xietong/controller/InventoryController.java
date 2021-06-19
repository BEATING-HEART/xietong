package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-09 20:58
 */
@Api(tags = {"库存查看 Sunforge"})
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    // 库存不可接口修改。只可查询
    // list 普通员工权限
    // get  普通员工权限
    @GetMapping("/list")
    public ResponseDTO listInventories(){
        return ResponseDTO.success("还没开发好");
    }

    @GetMapping("/get/{id}")
    public ResponseDTO getInventory(@PathVariable(name = "id") Integer id){
        return ResponseDTO.success("还没开发好");
    }
}
