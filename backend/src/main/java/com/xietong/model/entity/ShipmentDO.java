package com.xietong.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;
@Data

public class ShipmentDO {
    private int shipmentId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int saleId;
    private Date time;
    private int status;
    private List<ShipmentProductDO> shipmentProductDOList;

    public ShipmentDO() {
    }

    public ShipmentDO(int saleId, Date time) {
        this.saleId = saleId;
        this.time = time;
    }
}
