package com.xietong.constant.enums;

public enum ErrorCodeEnum implements ErrorCode{
    SUCCESS("200", "操作成功"),
    UNSPECIFIED("500", "未知错误")

    ;

    /** 错误码 */
    private final String code;

    /** 描述 */
    private final String description;


    ErrorCodeEnum(final String code, final String description) {
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
    public String getCode() {
        return code;
    }
    @Override
    public String getDescription() {
        return description;
    }


}
