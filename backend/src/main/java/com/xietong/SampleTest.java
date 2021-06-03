package com.xietong;

import com.xietong.mapper.StaffDOMapper;
import com.xietong.model.entity.StaffDO;
import org.jetbrains.annotations.TestOnly;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SampleTest {
    @Autowired
    private StaffDOMapper staffDOMapper;
    @Test
    public void test(){
        System.out.println("test");
        List<StaffDO> list=staffDOMapper.findAll();
        list.forEach(System.out::println);
    }
}
