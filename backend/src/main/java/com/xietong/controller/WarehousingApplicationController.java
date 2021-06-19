package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Author Sunforge
 * @Date 2021-06-09 21:02
 */
@Api(tags = {"入库申请单管理 Andrew"})
@RestController
@RequestMapping("/api/application")
public class WarehousingApplicationController {

//    @PostMapping("/insertApplication-product")
//    public List<warehousingApplicationDO> insertApplicationProduct(){
//        return  insertApplicationProduct(new warehousingApplicationDO());
//    }

    @PostMapping("/deleteApplication-product")
    @PreAuthorize("hasRole('workshopstaff')")
    public ResponseDTO deleteApplicationProduct(@PathVariable(name = "id") String id){
        return ResponseDTO.success("还没开发好");
    }

    @GetMapping("/listApplication-product")
    @PreAuthorize("hasAnyRole({'workshopstaff','warehousestaff','warehousemanager'})")
    public ResponseDTO listApplicationProduct(){
        return ResponseDTO.success("还没开发好");
    }

    @GetMapping("/getApplication-product/{id}")
    @PreAuthorize("hasAnyRole({'workshopstaff','warehousestaff','warehousemanager'})")
    public ResponseDTO getApplicationProduct(@PathVariable(name = "id") String id){
        return ResponseDTO.success("还没开发好");
    }

    @PostMapping("/updateApplication-product")
    @PreAuthorize("hasRole('workshopstaff')")
    public ResponseDTO updateApplicationProduct(@PathVariable(name = "id") String id){
        return ResponseDTO.success("还没开发好");
    }

    @PostMapping("/checkApplication-product")
    @PreAuthorize("hasRole('warehousestaff')")
    public ResponseDTO checkApplicationProduct(@PathVariable(name = "id") String id){
        return ResponseDTO.success("还没开发好");
    }

    @PostMapping("/confirmApplication-product")
    @PreAuthorize("hasRole('warehousemanager')")
    public ResponseDTO confirmApplicationProduct(@PathVariable(name = "id") String id){
        return ResponseDTO.success("还没开发好");
    }
    // insert  车间人员权限 【insert也填写application-product】
    // delete  车间人员权限（审核通过前可以删除）
    // update  车间人员权限（审核通过前可以修改，若修改则需要仓库管理员重新确认）【update也修改application-product】
    // list    车间人员/仓库人员/仓库经理 【联表查询】
    // get     车间人员/仓库人员/仓库经理 【联表查询 application-product】
    // check   仓库人员清点。 分 pass 和 非pass两种 【具体QQ上交流】
    // confirm 仓库经理审核。 分 pass 和 非pass两种 【具体QQ上交流】 【审核通过那修改inventory和warehousing】
}
