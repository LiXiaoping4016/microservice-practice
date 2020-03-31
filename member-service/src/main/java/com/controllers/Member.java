package com.controllers;

import com.model.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import member.model.User;
import member.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员服务
 *
 * @Author lixp23692
 * @Date 2020.03.19
 */
@RestController
@Api("会员服务")
public class Member {
    @Autowired
    private IMemberService memberService;

    @PostMapping("/getUserInfo")
    @ApiOperation("获取会员相关信息")
    @ApiImplicitParam(name = "id", value = "用户编号", required = true, dataType = "String")
    public BaseResponse getUserInfo(int id, String type) {
        return memberService.getUserInfo(id, type);
    }

    @PostMapping("/getUserInfoById")
    @ApiOperation("获取会员相关信息")
    @ApiImplicitParam(name = "id", value = "用户编号", required = true, dataType = "String")
    public User getUserInfoById(int id) {
        return memberService.getUserInfoById(id);
    }

}
