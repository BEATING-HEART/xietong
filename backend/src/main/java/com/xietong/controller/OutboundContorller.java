package com.xietong.controller;

import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.ShipmentDO;
import com.xietong.service.intf.OutboundDOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:49
 */
@Api(tags = {"出库单：是发货操作的记录 CJ"})
@RestController
@RequestMapping("/api/outbound")
public class OutboundContorller {
    @Autowired
    private OutboundDOService outboundDOService;
    // 出库单是发货操作的记录。不直接提供增删改接口

    // list 仓库经理，仓库人员
    // get  仓库经理，仓库人员
//    @GetMapping("/list")
////    @PreAuthorize("hasRole('accounting')")
//    public ResponseDTO listOutBounds(){
//        return ResponseDTO.success("还没开发好");
//    }

//    @GetMapping("/get/{id}")
////    @PreAuthorize("hasRole('accounting')")
//    public ResponseDTO getOutbound(@PathVariable(name = "id") Integer id){
//        return ResponseDTO.success("还没开发好");
//    }
    @PostMapping("/getOutboundBySaleId")
    @ApiOperation(value = "根据saleId获取对应的出库单")
    public ResponseDTO getOutboundBySaleId(@RequestBody Map<String ,Object> params){
        try {
            try {
                return ResponseDTO.success(outboundDOService.getBySaleId(Integer.parseInt(params.get("saleId").toString())));
            }catch (DataAccessException e){
                System.out.println(e);
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"数据库错误");
            }
        }catch (NullPointerException e){
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }
    }
    @PostMapping("/getOutboundByTime")
    @ApiOperation(value = "根据时间获取对应的出库单")
    public ResponseDTO getOutboundByTime(@RequestBody Map<String ,Object> params){
        try {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
                return ResponseDTO.success(outboundDOService.getByTime(simpleDateFormat.parse(params.get("time").toString())));
            }catch (DataAccessException e){
                System.out.println(e);
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"数据库错误");
            } catch (ParseException e) {
                e.printStackTrace();
                return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"日期格式有误");
            }
        }catch (NullPointerException e){
            return ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED,"参数不完整或错误");
        }
    }
}
