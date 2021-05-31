package com.xietong.model.dto;

import com.xietong.constant.enums.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;


/**
 * @Author Sunforge
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseDTO {
    private String code;
    private String message;
    private Object data;

    public ResponseDTO(@NonNull ErrorCode errorCode, @NonNull Object data){
        this.code = errorCode.getCode();
        this.message = errorCode.getDescription();
        this.data = data;
    }
}
