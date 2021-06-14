package com.xietong.controller.temp;


import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.ProductDO;
import com.xietong.model.entity.StaffDO;
//import com.xietong.model.entity.T.Test;
import com.xietong.service.intf.ProductDOService;
import com.xietong.service.intf.SaleOrderService;
import com.xietong.service.intf.StaffDOService;
import com.xietong.utils.MyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Api("测试类")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StaffDOService staffDOService;
    @Autowired
    private ProductDOService productDOService;
    @Autowired
    private SaleOrderService saleOrderService;
    @GetMapping("/hello")
    public String hello(){
        return "欢迎来到软件系统设计spring boot项目";
    }

    @GetMapping("/test")
    public ResponseDTO testResponse(){
        return ResponseDTO.success(new StaffDO("123","456","12346","135",true,1));
    }
    @GetMapping("/findAll")
    public List<StaffDO> findAll(){
        return staffDOService.findAll();
    }
    @GetMapping("/findOne/{id}")
    public List<StaffDO> findOne(@PathVariable(name = "id") String id){
        return staffDOService.findOneById(id);
    }
    @GetMapping("/removeOne/{id}")
    public int removeOne(@PathVariable(name = "id") String id){
        return staffDOService.removeOneById(id);
    }
    @PostMapping("/post-by-url-param")
    public ResponseDTO postUrlParam(@RequestParam Map<String, Object> params){
        // 也可以使用Bean对象来接收。
        System.out.println(params.toString());
        return ResponseDTO.success("成功接收路径请求参数",params);
    }
    @PostMapping("/post-by-json-param")
    public ResponseDTO postJson(@RequestBody Map<String, Object> params){
        // 也可以使用Bean对象来接收。
        return ResponseDTO.success("成功接收JSON参数",params);
    }


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
                else return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
            }catch (DataAccessException e){
                System.out.println(e);
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"加入产品失败");
            }
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
    @PostMapping("/insertSaleOrder")
    @ApiOperation(value = "插入销售单")
    public ResponseDTO insertSaleOrder(@RequestBody Map<String ,Object> params){
        try{
            try{
                Boolean a=saleOrderService.insert(params);
                if (a){
                    return ResponseDTO.success("插入成功");
                }else {
                    return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"插入失败");
                }

            }catch(DataAccessException | ParseException e){
                System.out.println(e);
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"插入失败");
            }
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }



    }
    @PostMapping("/listSaleOrder")
    @ApiOperation(value = "获取所有销售单及完整详情（包括销售单有哪些产品，发货批次及时间，每批次中产品的数量等）")
    public ResponseDTO listSaleOrder(){
        try{
            return ResponseDTO.success(saleOrderService.list());
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }


    }
    @PostMapping("/getByIdSaleOrder")
    @ApiOperation(value = "获取一个销售单及完整详情（包括销售单有哪些产品，发货批次及时间，每批次中产品的数量等）")
    public ResponseDTO getByIdSaleOrder(@RequestBody Map<String ,Object> params){
        try{
            System.out.println(Integer.parseInt(params.get("saleId").toString()));
            return ResponseDTO.success(saleOrderService.getById(Integer.parseInt(params.get("saleId").toString())));
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }


    }
    // confirm 销售经理审核。 分 pass 和 非pass两种 【具体QQ上交流】 【审核通过则修改状态】
    @PostMapping("/confirmStatus")
    @ApiOperation(value = "更改销售单状态 （status：0待审核；1通过；2：未通过）")
    public ResponseDTO confirmStatus(@RequestBody Map<String ,Object> params){
        try{
            if(saleOrderService.confirmStatus(Integer.parseInt(params.get("saleId").toString()),Integer.parseInt(params.get("status").toString()))!=0){
                return ResponseDTO.success("修改成功");
            }else {
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"修改失败");
            }
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }


    }
    @PostMapping("/confirmDeliveryStatus")
    @ApiOperation(value = "更改销售单发货状态 （deliverStatus：0:发货未完成；1发货完成）")
    public ResponseDTO confirmDeliveryStatus(@RequestBody Map<String ,Object> params){
        try{
            if(saleOrderService.confirmDeliveryStatus(Integer.parseInt(params.get("saleId").toString()),Integer.parseInt(params.get("deliveryStatus").toString()))!=0){
                return ResponseDTO.success("修改成功");
            }else {
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"修改失败");
            }
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }

    }
    @PostMapping("/deleteSale")
    @ApiOperation(value = "删除某一销售单及其之下的销售-产品记录，发货批次表，批次-产品记录")
    public ResponseDTO deleteSale(@RequestBody Map<String ,Object> params){
        try{
            if(saleOrderService.deleteSale(Integer.parseInt(params.get("saleId").toString()))){
                return ResponseDTO.success("删除成功");
            }else return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"删除失败");
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }

    }
    @PostMapping("/deleteSaleProduct")
    @ApiOperation(value = "删除某一销售单及其之下的销售-产品记录，发货批次表，批次-产品记录")
    public ResponseDTO deleteSaleProduct(@RequestBody Map<String ,Object> params){
        try{
            if (saleOrderService.deleteSaleProduct(Integer.parseInt(params.get("saleId").toString()),Integer.parseInt(params.get("productId").toString()))){
                return ResponseDTO.success("删除成功");
            }else return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"删除失败");
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }

    }
    @PostMapping("/deleteShipment")
    @ApiOperation(value = "删除某一批次及其之下的所有批次-产品记录")
    public ResponseDTO deleteShipment(@RequestBody Map<String ,Object> params){
        try{
            if(saleOrderService.deleteShipment(Integer.parseInt(params.get("shipmentId").toString()))){
                return ResponseDTO.success("删除成功");
            }else return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"删除失败");
        }catch (NullPointerException e){
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }

    }
    @PostMapping("/deleteShipmentProduct")
    @ApiOperation(value = "删除某一批次-产品记录")
    public ResponseDTO deleteShipmentProduct(@RequestBody Map<String ,Object> params){
        try{
            if (saleOrderService.deleteShipmentProduct(Integer.parseInt(params.get("shipmentId").toString()),Integer.parseInt(params.get("productId").toString()))){
                return ResponseDTO.success("删除成功");
            }else return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"删除失败");
        }catch (NullPointerException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }


    }

}


