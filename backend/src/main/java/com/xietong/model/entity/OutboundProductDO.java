package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutboundProductDO {
    @TableId
    private int productOutboundId;
    private int outboundId;
    private int productId;
    private int num;

    public OutboundProductDO(int outboundId, int productId, int num) {
        this.outboundId = outboundId;
        this.productId = productId;
        this.num = num;
    }
}
