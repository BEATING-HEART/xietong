package com.xietong.security;

import com.xietong.model.entity.StaffDO;
import com.xietong.service.intf.StaffDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Sunforge
 * @Date 2021-06-06 10:29
 * 返回 userDetailService 供security config 调用
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    StaffDOService staffDOService;

    @Override
    public UserDetails loadUserByUsername(String staffid) throws UsernameNotFoundException {

        StaffDO staff = staffDOService.findOneById(staffid).get(0);
        if (staff == null) {
            throw new UsernameNotFoundException("用户名或密码不正确");
        }
        return new SysUser(staff.getStaffId(), staff.getStaffPwd(), getUserAuthority(staff.getStaffId()));
//        return new SysUser(staff.getStuffId(), staff.getStuffPwd(), null);
//        return null;
    }

    /**
     * 获取用户权限信息（角色、菜单权限）
     * @param
     * @return
     */
    public List<GrantedAuthority> getUserAuthority(String staffId){
        String authority = staffDOService.getUserAuthorityInfo(staffId);
        System.out.println("[UserDetailServiceImpl] authority: " + authority);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
    }
}
