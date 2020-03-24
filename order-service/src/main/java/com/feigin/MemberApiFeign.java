package com.feigin;


import com.fallback.MemberFallback;
import member.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * feign
 *
 * @Author lixp23692
 * @Date 2019/8/28
 */
@FeignClient(name = "member", fallback = MemberFallback.class)
public interface MemberApiFeign extends IMemberService {
}

