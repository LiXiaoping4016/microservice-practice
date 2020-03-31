package com.fallback;


import com.feigin.MemberApiFeign;
import com.model.BaseResponse;
import com.model.ErrorEnum;
import com.service.BaseService;
import member.model.User;
import org.springframework.stereotype.Component;

/**
 * 服务降级
 *
 * @Author lixp23692
 * @Date 2019/9/1
 */
@Component
public class MemberFallback extends BaseService implements MemberApiFeign {
    /**
     * Hystrix默认开启线程池隔离，服务降级，服务隔离，服务熔断
     */
    @Override
    public BaseResponse getUserInfo(int id, String type) {
        return setError(ErrorEnum.E0001, "服务降级");
    }

    /**
     * Hystrix默认开启线程池隔离，服务降级，服务隔离，服务熔断
     */
    @Override
    public User getUserInfoById(int id) {
        System.out.println("服务降级");
        return null;
    }
}
