package com.xietong.mapper;


import com.xietong.model.entity.T.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    public List<Test> unionSelect(int id);
}
