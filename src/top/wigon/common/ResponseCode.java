package top.wigon.common;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/27 14:00
 **/
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 有错误
     */
    ERROR(1, "ERROR"),
    /**
     * 需要登录
     */
    NEED_LOGIN(10, "NEED_LOGIN"),
    /**
     * 参数异常
     */
    ILLEGAL_ARGUEMENT(2, "ILLEGAL_ARGUMENT");

    private final String desc;
    private final int code;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


}