package com.xietong.constant.enums;

public enum ErrorCodeEnum implements ErrorCode{
    // 通用成功
    SUCCESS(200, "操作成功"),
    // 通用异常
    UNSPECIFIED(400, "操作失败"),

    /** 4打头的错误码，是用于spring security 认证的 这个没有什么约定俗成，只是我随便规定的 */
    JWT_ERROR(4001, "token 异常"),
    JWT_EXPIRE(4002, "token 过期"),
    RQ_FORBIDDEN(4003, "访问权限不足"),
    RQ_UNAUTHORIZED(4004, "未登录"),

    STATUS_UNDEFINED(1001, "状态不存在"),
    STATUS_LOCKED(1002, "状态改变前置条件不满足")
    ;

    /** 错误码 */
    private final Integer code;

    /** 描述 */
    private final String description;


    ErrorCodeEnum(final Integer code, final String description) {
        // final保证了在类内，code，description不会被更改。
        this.code = code;
        this.description = description;
    }


    /**
     * 根据编码查询枚举。
     *
     * @param code 编码。
     * @return 枚举。
     */
    public static ErrorCodeEnum getByCode(String code) {
        for (ErrorCodeEnum value : ErrorCodeEnum.values()) {
            if (code.equals(value.getCode())) {
                return value;
            }
        }
        return UNSPECIFIED;
    }

    /**
     * 枚举是否包含此code
     * @param code 枚举code
     * @return 结果
     */
    public static Boolean contains(String code){
        for (ErrorCodeEnum value : ErrorCodeEnum.values()) {
            if (code.equals(value.getCode())) {
                return true;
            }
        }
        return  false;
    }
    @Override
    public Integer getCode() {
        return code;
    }
    @Override
    public String getDescription() {
        return description;
    }


}
