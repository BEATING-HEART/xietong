package com.xietong.controller;

import cn.hutool.core.map.MapUtil;
import com.xietong.model.dto.MenuDTO;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.model.dto.StaffDTO;
import com.xietong.model.entity.StaffDO;
import com.xietong.service.intf.SecurityMenuDOService;
import com.xietong.service.intf.StaffDOService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * @Author Sunforge
 * @Date 2021-06-12 9:55
 */
@Api(tags = {"首页显示 Sunforge"})
@RestController
@RequestMapping("/api/homepage")
public class HomePageController {

    @Autowired
    StaffDOService staffDOService;

    @Autowired
    SecurityMenuDOService securityMenuDOService;

    /**
     * 获取用户的个人信息，以及左边的导航栏菜单。
     * @param principal
     * @return
     */
    @GetMapping("/show")
    public ResponseDTO navigator(Principal principal){
        StaffDO staff = staffDOService.findOneById(principal.getName()).get(0);
        StaffDTO identity = new StaffDTO(staff);
        String authorityInfo = staffDOService.getUserAuthorityInfo(staff.getStaffId());
        String[] authorityInfoArray = StringUtils.tokenizeToStringArray(authorityInfo, ",");
//        List<MenuDTO> navs = securityMenuDOService.getCurStaffNav();
        return ResponseDTO.success(
                MapUtil.builder()
                    .put("identity", identity)
                    .put("authorities", authorityInfoArray)
//                    .put("nav", navs)
                    .map()
        );
    }

    /**
     * 获取用户的待处理消息
     * @param principal
     * @return
     */
    @GetMapping("/msg")
//    @PreAuthorize("hasRole('accounting')")
    public ResponseDTO getMessage(Principal principal){
        String staffId = principal.getName();
        return ResponseDTO.success(staffId + "message 接口未实现");
    }
}
