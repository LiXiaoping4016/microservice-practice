package com.controllers;

import com.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis
 *
 * @Author lixp23692
 * @Date 2020.03.30
 */
@RestController
public class Redis {
    @RequestMapping("/getValue")
    public String getValue(String key) {
        return (String) RedisUtil.get(key);
    }

    @RequestMapping("/setValue")
    public boolean setValue(String key, String value) {
        return RedisUtil.set(key, value);
    }

    @RequestMapping("/clearAll")
    public boolean clearAll() {
        return RedisUtil.clearAll();
    }
}
