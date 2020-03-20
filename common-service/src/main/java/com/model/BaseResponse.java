package com.model;

/**
 * 通用返回包
 *
 * @Author lixp23692
 * @Date 2019/8/31
 */
public class BaseResponse {
    private String code;
    private String msg;
    private Object data;

    public BaseResponse() {
        this.code = ErrorEnum.E0000.getErrCode();
        this.msg = ErrorEnum.E0000.getErrMsg();
    }

    public BaseResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "code:" + getCode() + "; msg:" + getMsg() + "; data:" + getData().toString();
    }
}
