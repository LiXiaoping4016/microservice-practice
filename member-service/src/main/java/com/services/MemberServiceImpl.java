package com.services;


import com.dao.UserDao;
import com.model.BaseResponse;
import com.service.BaseService;
import com.util.RedisUtil;
import member.model.User;
import member.service.IMemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 会员服务
 *
 * @Author lixp23692
 * @Date 2019/8/30
 */
@Service
public class MemberServiceImpl extends BaseService implements IMemberService {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private UserDao userDao;

    @Override
    public BaseResponse getUserInfo(int id, String type) {
        if ("1".equals(type)) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object result = RedisUtil.get(id);
        User user;
        if (result == null) {
            user = userDao.selectByPrimaryKey(id);
            RedisUtil.set(id, user);
        } else {
            user = (User) result;
        }
        user.setOtherDate("Port:" + serverPort);
        return setSuccess(user);
    }

    @Override
    public User getUserInfoById(int id) {
        Object result = RedisUtil.get(id);
        User user;
        if (result == null) {
            user = userDao.selectByPrimaryKey(id);
            RedisUtil.set(id, user);
        } else {
            user = (User) result;
        }
        return user;
    }
}
