package com.util;

import com.annotation.SetFieldValue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * bean工具类
 *
 * @Author lixp23692
 * @Date 2020.03.30
 */
@Component
public class BeanUtil implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setFieldValueForCol(Collection col) throws Exception {
        // 待补填数据的对象
        Class<?> clazz = col.iterator().next().getClass();
        // 缓存数据
        Map<String, Object> cache = new HashMap<String, Object>();
        // 遍历待补填数据对象的所有成员遍历
        for (Field targetField : clazz.getDeclaredFields()) {
            SetFieldValue annotation = targetField.getAnnotation(SetFieldValue.class);
            if (annotation == null) {
                continue;
            }
            targetField.setAccessible(true);
            // 获取源类和方法
            Object sourceBean = applicationContext.getBean(annotation.beanClass());
            Method sourceMethod = annotation.beanClass().getMethod(annotation.method(), clazz.getDeclaredField(annotation.param()).getType());
            // 查询数据入参
            Field inputField = clazz.getDeclaredField(annotation.param());
            inputField.setAccessible(true);
            Field outputField = null;
            boolean needInnerField = !StringUtils.isEmpty(annotation.targetField());
            String keyPrefix = annotation.beanClass() + "-" + annotation.method() + "-" + annotation.targetField() + "-";
            for (Object record : col) {
                Object inputValue = inputField.get(record);
                if (inputValue == null) {
                    continue;
                }
                Object outputValue;
                String key = keyPrefix + inputValue;
                if (cache.containsKey(key)) {
                    outputValue = cache.get(key);
                } else {
                    outputValue = sourceMethod.invoke(sourceBean, inputValue);
                    if (needInnerField) {
                        if (outputValue != null) {
                            // 首次执行获取返回对象的成员变量
                            if (outputField == null) {
                                outputField = outputValue.getClass().getDeclaredField(annotation.targetField());
                                outputField.setAccessible(true);
                            }
                            outputValue = outputField.get(outputValue);
                        }
                    }
                    cache.put(key, outputValue);
                }
                targetField.set(record, outputValue);
            }
        }
    }
}
