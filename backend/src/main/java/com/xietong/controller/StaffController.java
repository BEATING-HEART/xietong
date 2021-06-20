package com.xietong.controller;

import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.dto.StaffDTO;
import com.xietong.model.entity.StaffDO;
import com.xietong.service.intf.StaffDOService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author Sunforge
 * @Date 2021-06-09 20:39
 */
@Api(tags = {"员工的增删查改 Sunforge"})
@RestController
@RequestMapping("/api/staff")
@PreAuthorize("hasRole('admin')")
public class StaffController {

    @Autowired
    StaffDOService staffDOService;

    @PostMapping("/insert")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO insertStaff(@RequestBody StaffDO staff){
//        public ResponseDTO insertStaff(@RequestBody Map<String, Object> param){
        System.out.println("raw" + staff.toString());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(staff.getStaffPwd());
        staff.setStaffPwd(password);
        staff.setEffective(true);
        staff.setStatus(0);
        System.out.println("final" + staff.toString());
        if (staffDOService.insertStaff(staff))
            return ResponseDTO.success("插入员工成功", new StaffDTO(staff));
        else
            return ResponseDTO.fail("插入失败");
    }

    @PostMapping ("/delete/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO deleteStaffById(@PathVariable(name = "id") String id){
        int count = staffDOService.logicallyDeleteById(id);
        if(count == 0)
            return ResponseDTO.fail("用户不存在,或用户已失效");
        else
            return ResponseDTO.success("还没开发好");
    }

    @PostMapping ("/update")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO updateStaff(@RequestBody StaffDO staff){
//        System.out.println(staff.toString());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(staff.getStaffPwd());
        staff.setStaffPwd(password);
        staff.setEffective(true);
        staff.setStatus(0);
//        System.out.println(staff.toString());
        if(staffDOService.updateStaff(staff))
            return ResponseDTO.success(new StaffDTO(staff));
        else
            return ResponseDTO.fail("更新失败");
    }

    @PostMapping ("/get/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO getStaff(@PathVariable(name = "id") String id){
        System.out.println(staffDOService.findOneById(id));
        return ResponseDTO.success(new StaffDTO(staffDOService.findOneById(id).get(0)));
    }

    @GetMapping ("/list")
    @PreAuthorize("hasRole('admin')")
    public ResponseDTO listStaffs(){
//        System.out.println(staffDOService.findAll());
        Iterator<StaffDO> it = staffDOService.findAll().iterator();
        List<StaffDTO> staffs = new ArrayList<>();
        while(it.hasNext()) {
            StaffDTO obj = new StaffDTO(it.next());
            staffs.add(obj);
        }
        return ResponseDTO.success(staffs);
    }

}
