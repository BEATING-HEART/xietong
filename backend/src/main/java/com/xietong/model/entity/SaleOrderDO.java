package com.xietong.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class SaleOrderDO {
    @TableId
    private int saleId;
    private String sellerId;
    private String managerId;
    private int customerId;
    private String remarks;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    private int status;
    private int deliveryStatus ;
    private List<SaleProductDO> saleProductDOList;
    private List<ShipmentDO> shipmentDOList;

    public SaleOrderDO(String sellerId, int customerId, String remarks,Date time) {
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.remarks = remarks;
        this.time=time;
    }

    public SaleOrderDO(String sellerId, int customerId, String remarks) {
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.remarks = remarks;
    }

    public SaleOrderDO(int saleId, String sellerId, String managerId, int customerId, String remarks, Date time, int status, int deliveryStatus, List<SaleProductDO> saleProductDOList) {
        this.saleId = saleId;
        this.sellerId = sellerId;
        this.managerId = managerId;
        this.customerId = customerId;
        this.remarks = remarks;
        this.time = time;
        this.status = status;
        this.deliveryStatus = deliveryStatus;
        this.saleProductDOList = saleProductDOList;
    }
}
