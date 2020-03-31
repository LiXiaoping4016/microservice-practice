package com.annotation.aspect;

import com.annotation.NeedSetFieldValue;
import com.util.BeanUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 设置属性值
 *
 * @Author lixp23692
 * @Date 2020.03.30
 */
@Component
@Aspect
public class SetFieldValueAspect {
    @Autowired
    private BeanUtil beanUtil;

    @Around(value = "@annotation(needSetFieldValue)")
    public Object doSetFieldValue(ProceedingJoinPoint pjp, NeedSetFieldValue needSetFieldValue) throws Throwable {
        Object ret = pjp.proceed();
        beanUtil.setFieldValueForCol((Collection) ret);
        return ret;
    }
}
