package com.xietong.mapper;

import com.xietong.model.entity.WarehousingApplicationDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface WarehousingApplicationDOMapper {

    boolean insert(WarehousingApplicationDO warehousingApplicationDO);

    boolean delete(long warehousingApplicationId);

    List<WarehousingApplicationDO> list();

    List<WarehousingApplicationDO> getById(long warehousingApplicationId);

    boolean update(WarehousingApplicationDO warehousingApplicationDO);

    boolean confirm(long warehousingApplicationId, int status);
}
