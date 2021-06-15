package com.xietong.service.intf;

import com.xietong.model.dto.MenuDTO;
import com.xietong.model.entity.SecurityMenuDO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface SecurityMenuDOService {
    public List<SecurityMenuDO> findAll();
    public List<SecurityMenuDO> findOneById(String id);
    public int insertOne(SecurityMenuDO securityMenuDO);
    public int removeOne(String id);

    List<Long> listMenuIdsByStaffId(String staffId);
    List<Long> listMenuIdsByRoleId(String roleId);
    List<SecurityMenuDO> listByIds(@Param("list") List<Long> ids);

    List<MenuDTO> getCurStaffNav();
    List<SecurityMenuDO> listAsTree();
    Boolean hasChild(String id);
}
