package order.model;

import java.io.Serializable;

/**
 * 订单
 *
 * @Author lixp23692
 * @Date 2020.03.30
 */
public class Order implements Serializable {
    private int id;
    private String goods;
    private int userId;

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
}
