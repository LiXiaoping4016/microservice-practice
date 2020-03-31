package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要设置属性值
 *
 * @Author lixp23692
 * @Date 2020.03.30
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SetFieldValue {
    /**
     * 数据源的类
     */
    Class<?> beanClass();

    /**
     * 数据源的方法
     */
    String method();

    /**
     * 数据源的成员变量
     */
    String targetField();

    /**
     * 入参
     */
    String param();
}
