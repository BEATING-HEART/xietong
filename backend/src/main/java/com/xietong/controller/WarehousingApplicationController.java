package com.xietong.controller;


import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.service.intf.ApplicationProductDOService;
import com.xietong.service.intf.WarehousingApplicationDOService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @Author Sunforge
 * @Date 2021-06-09 21:02
 */
@Api(tags = {"入库申请单管理 Andrew"})
@RestController
@RequestMapping("/api/application")
public class WarehousingApplicationController {

    @Autowired
    WarehousingApplicationDOService warehousingApplicationDOService;

    @Autowired
    ApplicationProductDOService applicationProductDOService;


    @PostMapping("/insertApplication")
    public ResponseDTO insertApplication(@RequestBody Map<String ,Object> params){
        boolean staWarApp=warehousingApplicationDOService.insert(params);
        boolean staAppPro=applicationProductDOService.insert(params);
        if (staWarApp&&staAppPro)
        return ResponseDTO.success("入库申请插入成功",params);
        else
            return  ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

    @PostMapping("/deleteApplication")
    public ResponseDTO deleteApplication(@RequestBody Map<String ,Object> params){
        if(warehousingApplicationDOService.deleteWarehousingApplication((long)params.get("warehousingApplicationId")))
        return ResponseDTO.success("入库申请删除成功");
        else return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

    @GetMapping("/listApplication")
    public ResponseDTO listApplication(){

        return  ResponseDTO.success("成功显示",warehousingApplicationDOService.list());
    }

    @GetMapping("/getApplication")
    public ResponseDTO getApplication(@RequestBody Map<String ,Object> params){

        return  ResponseDTO.success(warehousingApplicationDOService.getById((long)params.get("warehousingApplicationId")));
    }

    @PostMapping("/updateApplication")
    public ResponseDTO updateApplication(@RequestBody Map<String ,Object> params){
        if(warehousingApplicationDOService.update(params))
        return  ResponseDTO.success("修改成功");
        else return  ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

    @ApiOperation(value = "清点入库单状态 （status：1:pass；0:not pass）")
    @PostMapping("/checkApplication")
    public ResponseDTO checkApplication(@RequestBody Map<String ,Object> params){
        if(applicationProductDOService.check((int)params.get("applyNum"),(int)params.get("actulNum")))
        return  ResponseDTO.success("check pass");
        else  return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

    @ApiOperation(value = "审核销售单状态 （status：0待审核；1通过；2：未通过）")
    @PostMapping("/confirmApplication")
    public ResponseDTO confirmApplication(@RequestBody Map<String ,Object> params){
        if(warehousingApplicationDOService.confirm((long)params.get("warehousingApplicationId"),(int)params.get("status")))
        return  ResponseDTO.success("状态修改成功");
        else return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }
    // insert  车间人员权限 【insert也填写application-product】
    // delete  车间人员权限（审核通过前可以删除）
    // update  车间人员权限（审核通过前可以修改，若修改则需要仓库管理员重新确认）【update也修改application-product】
    // list    车间人员/仓库人员/仓库经理 【联表查询】
    // get     车间人员/仓库人员/仓库经理 【联表查询 application-product】
    // check   仓库人员清点。 分 pass 和 非pass两种 【具体QQ上交流】
    // confirm 仓库经理审核。 分 pass 和 非pass两种 【具体QQ上交流】 【审核通过那修改inventory和warehousing】
}
