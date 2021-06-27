package com.xietong.mapper;

import com.xietong.model.entity.CustomerDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDOMapper {
    List<CustomerDO> list();

    CustomerDO getById(int customerId);

    boolean update(CustomerDO customerDO);

    boolean updateStatus(int customerId, int effective);

    @Insert({"insert into customer(customer_name, customer_phone, business_scope, address, effective)",
            "value(#{customerName}, #{customerPhone}, #{businessScope}, #{address}, true)"})
    @Options(useGeneratedKeys = true, keyProperty = "customerId")
    boolean insert(CustomerDO customerDO);
}
