package com.xietong.utils;

import com.xietong.constant.enums.ErrorCode;
import com.xietong.constant.enums.ErrorCodeEnum;

public class MyException extends RuntimeException{

    private static final long serialVersionUID = -7864604160297181941L;

    /** 错误码 */
    protected final ErrorCode errorCode;

    /**
     * 这个是和谐一些不必要的地方,冗余的字段
     * 尽量不要用
     */
    private String code;

    /**
     * 无参默认构造UNSPECIFIED
     */
    public MyException() {
        super(ErrorCodeEnum.UNSPECIFIED.getDescription());
        this.errorCode = ErrorCodeEnum.UNSPECIFIED;
    }

    /**
     * 指定错误码构造通用异常
     * @param errorCode 错误码
     */
    public MyException(final ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    /**
     * 指定详细描述构造通用异常
     * @param detailedMessage 详细描述
     */
    public MyException(final String detailedMessage) {
        super(detailedMessage);
        this.errorCode = ErrorCodeEnum.UNSPECIFIED;
    }

    /**
     * 指定导火索构造通用异常
     * @param t 导火索
     */
    public MyException(final Throwable t) {
        super(t);
        this.errorCode = ErrorCodeEnum.UNSPECIFIED;
    }

    /**
     * 构造通用异常
     * @param errorCode 错误码
     * @param detailedMessage 详细描述
     */
    public MyException(final ErrorCode errorCode, final String detailedMessage) {
        super(detailedMessage);
        this.errorCode = errorCode;
    }

    /**
     * 构造通用异常
     * @param errorCode 错误码
     * @param t 导火索
     */
    public MyException(final ErrorCode errorCode, final Throwable t) {
        super(errorCode.getDescription(), t);
        this.errorCode = errorCode;
    }

    /**
     * 构造通用异常
     * @param detailedMessage 详细描述
     * @param t 导火索
     */
    public MyException(final String detailedMessage, final Throwable t) {
        super(detailedMessage, t);
        this.errorCode = ErrorCodeEnum.UNSPECIFIED;
    }

    /**
     * 构造详细异常
     * @param errorCode 错误码
     * @param detailedMessage 详细描述
     * @param t 导火索
     */
    public MyException(final ErrorCode errorCode, final String detailedMessage,
                       final Throwable t) {
        super(detailedMessage, t);
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
