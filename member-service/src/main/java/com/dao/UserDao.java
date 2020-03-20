package com.dao;

import member.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户dao
 *
 * @Author lixp23692
 * @Date 2020.03.19
 */
@Mapper
public interface UserDao {
    User selectByPrimaryKey(@Param("id") int id);
}
