package com.impl;


import com.annotation.NeedSetFieldValue;
import com.dao.OrderDao;
import com.entity.FullOrder;
import com.feigin.MemberApiFeign;
import com.model.BaseResponse;
import com.service.BaseService;
import order.model.Order;
import order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单服务
 *
 * @Author lixp23692
 * @Date 2019/8/27
 */
@Service
public class OrderServiceImpl extends BaseService implements IOrderService {
    @Autowired
    private MemberApiFeign memberApifeign;
    @Resource
    private OrderDao orderDao;

    @Override
    public BaseResponse getOrder(int id) {
        Order order = orderDao.selectByPrimaryKey(id);
        return setSuccess(order);
    }

    @NeedSetFieldValue
    public List<FullOrder> getAllOrder() {
        List<FullOrder> orders = orderDao.selectAll();
        return orders;
    }

    @Override
    public BaseResponse getUserInfoFromMember(int id, String type) {
        return memberApifeign.getUserInfo(id, type);
    }

}
