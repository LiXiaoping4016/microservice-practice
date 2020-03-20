package com.model;

public enum ErrorEnum {
    /**
     * 成功
     */
    E0000("成功"),

    /**
     * 应用错误
     */
    E0001("应用错误"),

    /**
     * 用户名不能为空
     */
    E0002("user id can not be null");

    private String errCode;
    private String errMsg;

    ErrorEnum(String errMsg) {
        this.errCode = this.name();
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
