package com.xietong.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xietong.constant.enums.ErrorCode;
import com.xietong.constant.enums.ErrorCodeEnum;
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

    private ResponseDTO(@NonNull ErrorCode errorCode,  Object data){
        this.code = errorCode.getCode();
        this.message = errorCode.getDescription();
        this.data = data;
    }
    private ResponseDTO(@NonNull ErrorCode errorCode, @NotNull String message, Object data){
        this.code = errorCode.getCode();
        this.message = message;
        this.data = data;
    }

    public static ResponseDTO success(Object data){
        return new ResponseDTO(ErrorCodeEnum.SUCCESS, data);
    }

    public static ResponseDTO success(@NotNull String message, Object data){
        return new ResponseDTO(ErrorCodeEnum.SUCCESS, message, data);
    }

    public static  ResponseDTO fail(@NonNull ErrorCode errorCode,  Object data){
        return new ResponseDTO(errorCode, data);
    }

    public static  ResponseDTO fail(@NonNull ErrorCode errorCode, @NotNull String message, Object data){
        return new ResponseDTO(errorCode, message, data);
    }
}
