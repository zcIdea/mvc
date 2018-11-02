package com.ssm.redis;
 
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
 
public class RedisCache{
 
    /**
     * Jedis客户端
     */
    private Jedis redisClient = createClient();
 
    public String getObject(String key) {
        String ob = redisClient.get(key);
        if (ob == null) {
            return null;
        }
        return ob;
    }
 
    public void putObject(String key, String value) {
        redisClient.set(key, value);
    }
 
    public Object removeObject(String key) {
        return redisClient.expire(key.toString(), 0);
    }
 
    //创建redis连接池
    protected static Jedis createClient() {
 
        try {
            @SuppressWarnings("resource")
            JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
            return pool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("初始化连接池错误");
    }
    
    public static void main(String[] args) {
    	RedisCache rc = new RedisCache();
//    	rc.putObject("testKey", "testVale");
    	
    	String keyValue=rc.getObject("testKey");
    	System.out.println(keyValue);
    	
	}
 
}