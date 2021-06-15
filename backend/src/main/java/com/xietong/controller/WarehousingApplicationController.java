package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Sunforge
 * @Date 2021-06-09 21:02
 */
@Api("入库申请单操作")
@RestController
@RequestMapping("/api/application")
public class WarehousingApplicationController {

    @PostMapping("/insertApplication-product")
    public List<warehousingApplicationDO> insertApplicationProduct(){
        return  insertApplicationProduct(new warehousingApplicationDO());
    }

    @PostMapping("/deleteApplication-product")
    public int deleteApplicationProduct(@PathVariable(name = "id") String id){
        return  deleteApplicationProduct(id);
    }

    @GetMapping("/listApplication-product")
    public List<?> listApplicationProduct(){
        return  listApplicationProduct();
    }

    @GetMapping("/getApplication-product")
    public List<?> getApplicationProduct(){
        return  getApplicationProduct();
    }

    @PostMapping("/updateApplication-product")
    public int updateApplicationProduct(@PathVariable(name = "id") String id){
        return  updateApplicationProduct(id);
    }

    @PostMapping("/checkApplication-product")
    public int checkApplicationProduct(@PathVariable(name = "id") String id){
        return  checkApplicationProduct(id);
    }

    @PostMapping("/confirmApplication-product")
    public int confirmApplicationProduct(@PathVariable(name = "id") String id){
        return  confirmApplicationProduct(id);
    }
    // insert  车间人员权限 【insert也填写application-product】
    // delete  车间人员权限（审核通过前可以删除）
    // update  车间人员权限（审核通过前可以修改，若修改则需要仓库管理员重新确认）【update也修改application-product】
    // list    车间人员/仓库人员/仓库经理 【联表查询】
    // get     车间人员/仓库人员/仓库经理 【联表查询 application-product】
    // check   仓库人员清点。 分 pass 和 非pass两种 【具体QQ上交流】
    // confirm 仓库经理审核。 分 pass 和 非pass两种 【具体QQ上交流】 【审核通过那修改inventory和warehousing】
}
