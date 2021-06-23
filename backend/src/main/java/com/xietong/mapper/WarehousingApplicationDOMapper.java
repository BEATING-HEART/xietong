package com.xietong.mapper;

import com.xietong.model.entity.ApplicationProductDO;
import com.xietong.model.entity.WarehousingApplicationDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface WarehousingApplicationDOMapper {

    boolean insert(WarehousingApplicationDO warehousingApplicationDO);

    @Delete("delete from warehousing_application where warehousing_application_id = #{applicationId}")
    boolean delete(long applicationId);



    @Results(id = "applications", value = {
            @Result(property = "warehousingApplicationId", column = "warehousing_application_id", id = true),
            @Result(property = "applicationProducts", javaType = List.class,
                    many = @Many(select = "listApplicationProductById"), column = "warehousing_application_id")
    })
    @Select("select * from warehousing_application")
    List<WarehousingApplicationDO> listApplication();

    @Select({
            "select ap.*,p.product_name from application_product as ap ",
            "inner join product as p on ap.product_id = p.product_id ",
            "where ap.warehousing_application_id = #{applicationId}"
    })
    @Results(id = "products", value = {
            @Result(property = "productName", column = "product_name")
    })
    List<ApplicationProductDO> listApplicationProductById(Long applicationId);

    @Select("select * from warehousing_application where warehousing_application_id = #{applicationId}")
    @ResultMap(value = "applications")
    List<WarehousingApplicationDO> getById(long applicationId);



    boolean update(WarehousingApplicationDO warehousingApplicationDO);

    boolean confirm(long warehousingApplicationId, int status);
}
