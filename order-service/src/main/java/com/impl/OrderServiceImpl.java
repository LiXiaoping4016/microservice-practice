package com.impl;


import com.feigin.MemberApifeign;
import com.model.BaseResponse;
import com.service.BaseService;
import order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单服务
 *
 * @Author lixp23692
 * @Date 2019/8/27
 */
@Service
public class OrderServiceImpl extends BaseService implements IOrderService {
    @Autowired
    private MemberApifeign memberApifeign;

    @Override
    public BaseResponse getOrder(String busin) {
        return setSuccess(busin + "成功");
    }

    @Override
    public BaseResponse getUserInfoFromMember(int id, String type) {
        return memberApifeign.getUserInfo(id, type);
    }

}
