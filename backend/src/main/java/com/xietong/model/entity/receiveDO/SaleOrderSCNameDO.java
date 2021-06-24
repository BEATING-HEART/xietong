package com.xietong.model.entity.receiveDO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xietong.model.entity.SaleProductDO;
import com.xietong.model.entity.ShipmentDO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
public class SaleOrderSCNameDO {
    @TableId
    private int saleId;
    private String sellerId;
    private String sellerName;
    private String managerId;
    private int customerId;
    private String customerName;
    private String remarks;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    private int status;
    private int deliveryStatus ;
    private List<SaleProductPNameDO> saleProductPNameDOList;
    private List<ShipmentPNameDO> ShipmentPNameDOList;

    public SaleOrderSCNameDO(String sellerId, int customerId, String remarks,Date time) {
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.remarks = remarks;
        this.time=time;
    }

    public SaleOrderSCNameDO(String sellerId, int customerId, String remarks) {
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.remarks = remarks;
    }

    public SaleOrderSCNameDO(int saleId, String sellerId, String managerId, int customerId, String remarks, Date time, int status, int deliveryStatus,  List<SaleProductPNameDO> saleProductPNameDOList) {
        this.saleId = saleId;
        this.sellerId = sellerId;
        this.managerId = managerId;
        this.customerId = customerId;
        this.remarks = remarks;
        this.time = time;
        this.status = status;
        this.deliveryStatus = deliveryStatus;
        this.saleProductPNameDOList =saleProductPNameDOList;
    }

    public SaleOrderSCNameDO(int saleId, String sellerId, String sellerName, String managerId, int customerId, String customerName, String remarks, Date time, int status, int deliveryStatus, List<SaleProductPNameDO> saleProductPNameDOList) {
        this.saleId = saleId;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.managerId = managerId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.remarks = remarks;
        this.time = time;
        this.status = status;
        this.deliveryStatus = deliveryStatus;
        this.saleProductPNameDOList = saleProductPNameDOList;
    }
}
