package com.entity;

import com.annotation.SetFieldValue;
import com.feigin.MemberApiFeign;

import java.io.Serializable;

/**
 * 全量订单信息
 *
 * @Author lixp23692
 * @Date 2020.03.30
 */
public class FullOrder implements Serializable {
    private int id;
    private String goods;
    private int userId;

    @SetFieldValue(beanClass = MemberApiFeign.class, method = "getUserInfoById", targetField = "name", param = "userId")
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
