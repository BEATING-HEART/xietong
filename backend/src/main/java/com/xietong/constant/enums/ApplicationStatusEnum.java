package com.xietong.constant.enums;

import com.xietong.utils.MyException;
import io.swagger.models.auth.In;

/**
 * @Author Sunforge
 * @Date 2021-06-26 15:31
 */
public enum ApplicationStatusEnum {
    UNHANDLED(1,"未处理"),
    CHECKED(2,"待审核"),
    CHECK_FAILED(3,"清点不通过"),
    PASS(4, "审核通过"),
    FAIL(5, "审核不通过");

    private ApplicationStatusEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(Integer code){
        for (ApplicationStatusEnum  status: values()) {
          if(status.getCode() == code){
              return  status.getName();
          }
        }
        throw new MyException();
    }
}
