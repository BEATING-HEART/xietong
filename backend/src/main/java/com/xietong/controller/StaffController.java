package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.entity.StaffDO;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Sunforge
 * @Date 2021-06-09 20:39
 */
@Api(tags = {"员工的增删查改 Sunforge"})
@RestController
@RequestMapping("/api/staff")
@PreAuthorize("hasRole('admin')")
public class StaffController {

    @PostMapping("/insert")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO insertStaff(@RequestBody StaffDO staff){
        return ResponseDTO.success("还没开发好");
    }

    @PostMapping ("/delete/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO deleteStaffById(@PathVariable(name = "id") String id){
        return ResponseDTO.success("还没开发好");
    }

    @PostMapping ("/update")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO updateStaff(@RequestBody StaffDO staff){
        return ResponseDTO.success("还没开发好");
    }

    @PostMapping ("/get/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO getStaff(@PathVariable(name = "id") String id){
        return ResponseDTO.success("还没开发好");
    }

    @GetMapping ("/list")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO listStaffs(){
        return ResponseDTO.success("还没开发好");
    }

    // insert 都是管理员权限
    // delete
    // update
    // list
    // get
}
