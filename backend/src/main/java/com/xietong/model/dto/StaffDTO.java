package com.xietong.model.dto;

import com.xietong.model.entity.StaffDO;
import lombok.Data;

/**
 * @Author Sunforge
 * @Date 2021-06-13 23:55
 */
@Data
public class StaffDTO {

    private String staffId;
    private String position;
    private String name;

    public StaffDTO(StaffDO staff){
        this.name = staff.getStuffName();
        this.position = staff.getStuffPosition();
        this.staffId = staff.getStuffId();
    }
}
