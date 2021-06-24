package com.xietong.model.entity.receiveDO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutboundProductNameDO {
    @TableId
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int productOutboundId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int outboundId;
    private int productId;
    private String productName;
    private int num;
}
