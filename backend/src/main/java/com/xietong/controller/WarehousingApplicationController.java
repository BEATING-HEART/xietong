package com.xietong.controller;


import com.xietong.constant.enums.ApplicationStatusEnum;
import com.xietong.model.entity.ApplicationProductDO;
import com.xietong.model.entity.WarehousingApplicationDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * @Author Sunforge
 * @Date 2021-06-09 21:02
 */
@Api(tags = {"入库申请单管理 Sunforge"})
@RestController
@RequestMapping("/api/application")
public class WarehousingApplicationController {

    @Autowired
    WarehousingApplicationDOService warehousingApplicationDOService;

    @Autowired
    ApplicationProductDOService applicationProductDOService;

    @PostMapping("/insert")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehousingApplicationId", value = "入库申请单id",  required = false),
    })
    public ResponseDTO insertApplication(@RequestBody WarehousingApplicationDO application, Principal principal){
        String staffId = principal.getName();
        application.setStatus(ApplicationStatusEnum.UNHANDLED.getCode());
        application.setStaffId(staffId);
        application.setWorkshopId(1);
        if (warehousingApplicationDOService.insertWarehousingApplication(application))
            return  ResponseDTO.success("入库申请提交成功");
        else
            return ResponseDTO.fail("入库申请提交失败");
    }

    @PostMapping("/delete/{applicationId}")
    public ResponseDTO deleteApplication(@PathVariable(name = "applicationId") Long id){
        if(warehousingApplicationDOService.deleteWarehousingApplication(id))
            return ResponseDTO.success("入库申请删除成功");
        else
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED);
    }

    @GetMapping("/list")
    public ResponseDTO listApplication(){
        return  ResponseDTO.success("成功显示",warehousingApplicationDOService.list());
    }

    @GetMapping("/get/{applicationId}")
    public ResponseDTO getApplication(@PathVariable(name = "applicationId") Long id){
        WarehousingApplicationDO application = warehousingApplicationDOService.getById(id);
        return  ResponseDTO.success(application);
    }

    @PostMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applicationId", value = "入库申请单id",  required = true),
    })
    public ResponseDTO updateApplication(@RequestBody WarehousingApplicationDO application, Principal principal){
        warehousingApplicationDOService.update(application);
        return  ResponseDTO.success("修改成功");
    }

    @ApiOperation(value = "清点入库单状态 ")
    @PostMapping("/check/{applicationId}/{result}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applicationId", value = "入库申请单id",  required = true),
            @ApiImplicitParam(name = "result", value = "仓库员工清点是否通过",  required = true),
    })
//    @PreAuthorize("hasRole('warehousestaff')")
    public ResponseDTO checkApplication(@PathVariable(name = "applicationId") Long applicationId,
                                        @PathVariable(name = "result") Boolean result){
        if(result){
            warehousingApplicationDOService.check(applicationId, result);
            return ResponseDTO.success("清点校验通过");
        }
        else
            return ResponseDTO.success("清点校验不通过");
    }

    @ApiOperation(value = "审核销售单状态 ")
    @PostMapping("/confirm/{applicationId}/{result}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applicationId", value = "入库申请单id",  required = true),
            @ApiImplicitParam(name = "result", value = "仓库经理审核是否通过",  required = true),
    })
//    @PreAuthorize("hasRole('warehousemanager')")
    public ResponseDTO confirmApplication(@PathVariable(name = "applicationId") Long applicationId,
                                          @PathVariable(name = "result") Boolean result){
        if(result){
            warehousingApplicationDOService.confirm(applicationId, result);
            return ResponseDTO.success("入库审核通过");
        }
        else
            return ResponseDTO.success("入库审核不通过");
    }

}
