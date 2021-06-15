package com.xietong.controller;

import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.service.intf.SaleOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Map;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:43
 */
@Api("销售销售单操作")
@RestController
@RequestMapping("/api/sale")
public class SalesOrderController {
    @Autowired
    private SaleOrderService saleOrderService;
    // insert  销售人员权限 【insert也填写order-product，shipment，shipment-product】
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
    // delete  销售人员权限（审核通过前可以删除）
    //(1)删除销售单
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
    //（2）删除销售单与产品的关系
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
    //(3)删除某一发货批次
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
    //（4）删除某一发货批次下的批次与产品的关系
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


    // update  销售人员权限（审核通过前可以修改）【update也修改order-product，shipment， shipemnt-product】
    //（1）修改销售单的基本信息
    //（2）修改销售单与产品的关系
    //（3）修改批次信息
    //（4）修改某一批发货次下的批次与产品的关系




    // list    销售人员/销售经理 【联表查询，查order-product 。。。】
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
    // get     销售人员/销售经理 【联表查询，查order-product 。。。】
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
}
