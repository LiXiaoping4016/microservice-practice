package com.service;


import com.model.BaseResponse;
import com.model.ErrorEnum;

/**
 * 通用服务
 *
 * @Author lixp23692
 * @Date 2019/8/31
 */
public class BaseService {
    public BaseResponse setError(ErrorEnum errorEnum) {
        return setResult(errorEnum.getErrCode(), errorEnum.getErrMsg(), null);
    }

    public BaseResponse setError(ErrorEnum errorEnum, Object data) {
        return setResult(errorEnum.getErrCode(), errorEnum.getErrMsg(), data);
    }

    public BaseResponse setSuccess(Object data) {
        return setResult(ErrorEnum.E0000.getErrCode(), ErrorEnum.E0000.getErrMsg(), data);
    }

    public BaseResponse setSuccess() {
        return setResult(ErrorEnum.E0000.getErrCode(), ErrorEnum.E0000.getErrMsg(), null);
    }

    private BaseResponse setResult(String code, String msg, Object data) {
        return new BaseResponse(code, msg, data);
    }
}
