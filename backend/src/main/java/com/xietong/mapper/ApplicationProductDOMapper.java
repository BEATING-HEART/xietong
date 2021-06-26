package com.xietong.mapper;

import com.xietong.model.entity.ApplicationProductDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ApplicationProductDOMapper {
//    @Insert("INSERT INTO application_product(warehousing_application_id, product_id, batch_id, apply_num," +
//            "actul_num, effective, good_num, bad_num) VALUES")
    Boolean insertList(@Param("applicationId") Long applicationId,  @Param("products") List<ApplicationProductDO> applicationProducts);

    @Delete("delete from application_product where warehousing_application_id = #{applicationId}")
    Boolean delete(long applicationId);

    @Select("select * from application_product where warehousing_application_id = #{applicationId}")
    List<ApplicationProductDO> listApplicationProduct(Long applicationId);
}
