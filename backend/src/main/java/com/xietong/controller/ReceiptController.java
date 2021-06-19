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
 * @Date 2021-06-10 10:50
 */
@Api(tags = {"收款：得到一笔汇款记一次 Sunforge"})
@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {
    // insert 即收款。
    @GetMapping("/insert")
    @ApiOperation("向外部系统提供")
    @PreAuthorize("hasRole('accounting')")
    public ResponseDTO insertReceipt(){
        return ResponseDTO.success("还没开发好");
    }
    // list   财务人员
    // get    财务人员
    @GetMapping("/list")
    @PreAuthorize("hasRole('accounting')")
    public ResponseDTO listReceipts(){
        return ResponseDTO.success("还没开发好");
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('accounting')")
    public ResponseDTO getReceipt(@PathVariable(name = "id") Integer id){
        return ResponseDTO.success("还没开发好");
    }
}
