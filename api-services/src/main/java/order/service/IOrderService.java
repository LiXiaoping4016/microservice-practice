package order.service;

import com.model.BaseResponse;

/**
 * 订单服务接口
 *
 * @Author lixp23692
 * @Date 2019/8/30
 */
public interface IOrderService {
    BaseResponse getOrder(int id);

    BaseResponse getUserInfoFromMember(int id, String type);
}

