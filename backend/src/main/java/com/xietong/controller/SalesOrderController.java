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
    @PostMapping("/insert")
    @ApiOperation(value = "插入销售单")
    public ResponseDTO insertSaleOrder(@RequestBody Map<String ,Object> params){
        try{
            Boolean flag=saleOrderService.insert(params);
            if (flag){
                return ResponseDTO.success("插入成功");
            }else {
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"插入失败");
            }

        }catch(DataAccessException | ParseException e){
            System.out.println(e);
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"插入失败");
        }

    }
    // delete  销售人员权限（审核通过前可以删除）

    // update  销售人员权限（审核通过前可以修改）【update也修改order-product，shipment， shipemnt-product】
    
    // list    销售人员/销售经理 【联表查询，查order-product 。。。】
    @PostMapping("/listSaleOrder")
    @ApiOperation(value = "获取所有销售单及完整详情（包括销售单有哪些产品，发货批次及时间，每批次中产品的数量等）")
    public ResponseDTO listSaleOrder(){
        return ResponseDTO.success(saleOrderService.list());
    }
    // get     销售人员/销售经理 【联表查询，查order-product 。。。】
    @PostMapping("/getByIdSaleOrder")
    @ApiOperation(value = "获取一个销售单及完整详情（包括销售单有哪些产品，发货批次及时间，每批次中产品的数量等）")
    public ResponseDTO getByIdSaleOrder(@RequestBody Map<String ,Object> params){
        System.out.println(Integer.parseInt(params.get("saleId").toString()));
        return ResponseDTO.success(saleOrderService.getById(Integer.parseInt(params.get("saleId").toString())));
    }
    // confirm 销售经理审核。 分 pass 和 非pass两种 【具体QQ上交流】 【审核通过则修改状态】


}
