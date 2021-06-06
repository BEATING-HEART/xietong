package com.xietong;

import com.xietong.mapper.StaffDOMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@MapperScan("com.xietong.mapper")
public class BackendprojApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(BackendprojApplication.class, args);
//        System.out.println(appContext.getBean("StaffDO"));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("123456");
        System.out.println(password);


    }

}
