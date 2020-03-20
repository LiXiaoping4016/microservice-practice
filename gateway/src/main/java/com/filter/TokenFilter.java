package com.filter;

import com.model.ErrorEnum;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关过滤
 *
 * @Author lixp23692
 * @Date 2019/9/2
 */
//@Component
public class TokenFilter extends ZuulFilter {
    @Value("${server.port}")
    private String serverPort;

    @Override
    public Object run() {
        // 1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 2.获取 Request
        HttpServletRequest request = currentContext.getRequest();
        // 3.获取token 的时候 从请求头中获取
        String name = request.getParameter("id");
        if (StringUtils.isEmpty(name)) {
            // 不会继续执行... 不会去调用服务接口，网关服务直接响应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody(ErrorEnum.E0002.getErrMsg());
            currentContext.setResponseStatusCode(401);
            return null;
        }
        // 正常执行调用其他服务接口...
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器执行顺序,当一个请求在同一个阶段的时候存在多个过滤器的时候，多个过滤器执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 过滤类型 pre 表示在请求之前进行执行
    @Override
    public String filterType() {
        return "pre";
    }
}