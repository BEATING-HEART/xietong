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
    private Integer code;
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

    /**
     * 操作成功 code 200 message 操作成功
     * @param data 可携带一个对象类型的数据
     * @return response DTO对象
     */
    public static ResponseDTO success(Object data){
        return new ResponseDTO(ErrorCodeEnum.SUCCESS, data);
    }

    /**
     * 操作成功 code 200
     * @param message 可设定成功状态的自定义message
     * @param data 可携带一个对象类型的数据
     * @return response DTO对象
     */
    public static ResponseDTO success(@NotNull String message, Object data){
        return new ResponseDTO(ErrorCodeEnum.SUCCESS, message, data);
    }

    /**
     * 操作失败。
     * @param errorCode 自定义error code。值来自ErrorCodeEnum类。
     * @return response DTO对象
     */
    public static  ResponseDTO fail(@NonNull ErrorCode errorCode){
        return new ResponseDTO(errorCode, null);
    }

    /**
     * 操作失败
     * @param errorCode 自定义error code。值来自ErrorCodeEnum类。
     * @param message 可自定义错误状态的message
     * @return response DTO对象
     */
    public static  ResponseDTO fail(@NonNull ErrorCode errorCode, @NotNull String message){
        return new ResponseDTO(errorCode, message, null);
    }

//    public static  ResponseDTO fail(@NonNull ErrorCode errorCode, @NotNull String message, Object data){
//        return new ResponseDTO(errorCode, message, data);
//    }
}
