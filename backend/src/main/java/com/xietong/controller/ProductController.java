package com.xietong.controller;

import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.ProductDO;
import com.xietong.service.intf.ProductDOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Sunforge
 * @Date 2021-06-09 20:55
 */
@Api("产品操作")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductDOService productDOService;

    /**
     * 产品插入
     * @param params
     * @return
     */
    // insert 管理员权限
    @PostMapping("/insert")
    @ApiOperation(value = "加入产品")
    public ResponseDTO insertProduct(@RequestBody Map<String ,Object> params){
        try{
            try{
                int flag=productDOService.insert(new ProductDO(Integer.parseInt(params.get("productId").toString()),params.get("productName").toString(),params.get("description").toString(),params.get("unit").toString()));
                if (flag==1)return ResponseDTO.success("加入产品成功",params);
            }catch (DataAccessException e){
                System.out.println(e);
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"加入产品失败");
            }
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"系统错误");
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }



    }
    // delete 管理员权限
    @PostMapping("/delete")
    @ApiOperation(value = "根据产品id删除产品")
    public ResponseDTO deleteProduct(@RequestBody Map<String ,Object> params){
        try{
            try {
                int flag=productDOService.updateEffective(Integer.parseInt(params.get("productId").toString()),0);
                if (flag==1){
                    return ResponseDTO.success("删除成功");
                }else {
                    return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"产品不存在");
                }
            }catch (DataAccessException e ){
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"删除产品失败");
            }
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }


    }
    // list   普通员工权限
    @PostMapping("/list")
    @ApiOperation(value = "查询全部产品")
    public ResponseDTO list(){
        try{
            return ResponseDTO.success(productDOService.list());
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }

    }
    // get    普通员工权限
    @PostMapping("/getById")
    @ApiOperation(value = "根据产品id查询产品")
    public ResponseDTO getById(@RequestBody Map<String ,Object> params){
        try{
            return ResponseDTO.success(productDOService.getById(Integer.parseInt(params.get("productId").toString())));
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }


    }
    //update
    @PostMapping("/update")
    @ApiOperation(value = "更改产品的信息")
    public ResponseDTO update(@RequestBody Map<String ,Object> params){
        try{
            try{
                if(productDOService.update(new ProductDO(Integer.parseInt(params.get("productId").toString()),params.get("productName").toString(),params.get("description").toString(),params.get("unit").toString()))==1){
                    return ResponseDTO.success("更改成功");
                }else {
                    return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"更改失败");
                }
            }catch (DataAccessException e){
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"更改失败");
            }
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }


    }
}
