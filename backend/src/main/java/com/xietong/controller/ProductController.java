package com.xietong.controller;

import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.ProductDO;
import com.xietong.service.intf.ProductDOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author Sunforge
 * @Date 2021-06-09 20:55
 */
@Api(tags = {"产品的增删查改 CJ"})
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductDOService productDOService;

    /**
     * 产品插入
     * @param
     * @return
     */
    // insert 管理员权限
    @PostMapping("/insert")
    @ApiOperation(value = "加入产品 ")
    @PreAuthorize("hasRole('admin')")
//    public ResponseDTO insertProduct(@RequestBody Map<String ,Object> params){
    public ResponseDTO insertProduct(@RequestBody ProductDO product){
        try{
            try{
                int flag=productDOService.insert(product);
                if (flag==1)return ResponseDTO.success("加入产品成功",product);
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
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "根据产品id删除产品")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO deleteProduct(@PathVariable(name = "id") Integer productId){
        try{
            try {
                int flag=productDOService.updateEffective(productId,0);
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
    @PreAuthorize("hasRole('basic')")
    public ResponseDTO list(){
        try{
            return ResponseDTO.success(productDOService.list());
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }

    }
    // get    普通员工权限
    @PostMapping("/get/{id}")
    @ApiOperation(value = "根据产品id查询产品")
    @PreAuthorize("hasRole('basic')")
    public ResponseDTO getById(@PathVariable(name = "id") Integer productId){
        return ResponseDTO.success(productDOService.getById(productId));
    }
    //update
    @PostMapping("/update")
    @ApiOperation(value = "更改产品的信息")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO update(@RequestBody ProductDO product){
        try{
            try{
                if(productDOService.update(product) == 1){
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
