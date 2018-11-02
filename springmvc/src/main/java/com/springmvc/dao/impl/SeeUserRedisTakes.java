package com.springmvc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springmvc.dao.RedisBaiseTakes;
import com.springmvc.entry.SeeUser;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
 * redis操作实现类
 *
 */
//@Component("seeUserRedisTakes")
@Service
public class SeeUserRedisTakes implements RedisBaiseTakes<String,String,SeeUser>{
	
//    @Resource(name="redisTemplate")
	@Autowired
    private RedisTemplate<String, String> redisTemplate;

    private Logger logger = Logger.getLogger(String.valueOf(SeeUserRedisTakes.class));
    @Override
    public void add(String key, String value) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
           redisTemplate.opsForValue().set(key,value);
        }
    }

    @Override
    public void addObj(String objectKey, String key, SeeUser object) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
            redisTemplate.opsForHash().put(objectKey,key,object.toString());
        }
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void delete(List<String> listKeys) {

    }

    @Override
    public void deletObj(String objecyKey, String key) {

    }

    @Override
    public void update(String key, String value) {

    }

    @Override
    public void updateObj(String objectKey, String key, SeeUser object) {

    }

    @Override
    public String get(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }

    @Override
    public SeeUser getObj(String objectKey, String key) {
        SeeUser seeUser = (SeeUser) redisTemplate.opsForHash().get(objectKey,key);
        return seeUser;
    }
}