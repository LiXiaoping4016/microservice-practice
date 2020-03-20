package com.controllers;

import com.impl.OrderServiceImpl;
import com.model.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单服务
 *
 * @Author lixp23692
 * @Date 2020.03.19
 */
@RestController
@Api("订单服务")
public class Order {
    @Resource
    private OrderServiceImpl orderService;

    @PostMapping("/getOrder")
    @ApiOperation("下单")
    @ApiImplicitParam(name = "busin", value = "业务", required = true, dataType = "String")
    BaseResponse getOrder(String busin) {
        return orderService.getOrder(busin);
    }

    @PostMapping("/getUserInfoFromMember")
    @ApiOperation("调会员服务查询用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String")
    BaseResponse getUserInfoFromMember(int id, String type) {
        return orderService.getUserInfoFromMember(id, type);
    }

}
