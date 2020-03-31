package com.dao;

import com.entity.FullOrder;
import order.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单dao
 *
 * @Author lixp23692
 * @Date 2020.03.30
 */
@Mapper
public interface OrderDao {
    Order selectByPrimaryKey(@Param("id") int id);

    List<FullOrder> selectAll();
}
