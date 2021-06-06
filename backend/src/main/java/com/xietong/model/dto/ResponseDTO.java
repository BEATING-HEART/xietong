package com.xietong.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xietong.constant.enums.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;


/**
 * @Author Sunforge
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseDTO {
    private String code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public ResponseDTO(@NonNull ErrorCode errorCode,  Object data){
        this.code = errorCode.getCode();
        this.message = errorCode.getDescription();
        this.data = data;
    }
    public ResponseDTO(@NonNull ErrorCode errorCode, @NotNull String message, Object data){
        this.code = errorCode.getCode();
        this.message = message;
        this.data = data;
    }
}
