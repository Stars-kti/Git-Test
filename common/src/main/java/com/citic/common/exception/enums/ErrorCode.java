package com.citic.common.exception.enums;

/**
 * 系统异常类
 * @author Kuro
 */
public enum ErrorCode {

    /**
     * 操作成功
     */
    OK(0, ""),

    /**
     * 操作失败
     */
    FAIL(-1, "操作失败"),

    /**
     * 跨服务调用是产生失败
     */
    RPC_ERROR(-2,"远程调度失败"),

    /**
     * 数据库中没有这个用户名
     */
    USER_NOT_FOUND(1000,"用户不存在"),

    /**
     * 用户或密码填写错误
     */
    USER_PASSWORD_ERROR(1001,"用户或密码错误"),

    /**
     * 远程授权服务时，因授权服务异常或者参数错误导致的失败
     */
    GET_TOKEN_FAIL(1002,"获取token失败"),

    /**
     * 用户使用的token和用户名对应失败
     */
    TOKEN_IS_NOT_MATCH_USER(1003,"请使用自己的token进行接口请求"),

    /**
     * 数据库中存在重复的用户名
     */
    USERNAME_REPEAT(1004,"用户名重复"),

    /**
     * 从数据库中调用用户信息出错
     */
    GET_USER_FAIL(1005,"获取用户信息失败"),

    /**
     * 填写的密码不符合预定的标准值
     */
    PASSWORD_ERROR(1006,"验证密码出现错误"),

    /**
     * 接收的文件格式和预期的格式不一致
     */
    FILE_FORMAT_ERROR(1100,"文件格式不正确"),

    /**
     * 再读取文件时出错
     */
    READ_FILE_ERROR(1101, "读取文件异常");

    private int code;
    private String msg;


    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ErrorCode codeOf(int code) {
        for (ErrorCode state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return null;
    }
}