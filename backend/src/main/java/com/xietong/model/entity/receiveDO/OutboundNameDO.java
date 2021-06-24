package com.xietong.model.entity.receiveDO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutboundNameDO {
    @TableId
    private int outboundId;
    private int saleId;
    private String staffId;
    private String staffName;
    private int customerId;
    private String customerName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    private int shipmentId;
    private List<OutboundProductNameDO> outboundProductNameDOList;
}
