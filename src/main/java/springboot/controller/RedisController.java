package springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.redis.RedisProperties;
import springboot.redis.RedisUtil;

/**
    * @Title: RedisController
    * @ProjectName springbootdemo
    * @Description: TODO
    * @author YangPeng
    * @date 2019/4/3-17:55
    */
@RestController
@RequestMapping(value="/") 
public class RedisController {
    @Autowired
    private RedisProperties redisProperties;

//    @Autowired
//    private RedisConfig redisConfig;
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Autowired
    RedisUtil redisUtil;
    
//    @Autowired
//    private JedisClientCluster jedisClientCluster;

    @RequestMapping(value = "getRedisValue")
    public String getRedisValue(){
        System.out.println(redisProperties.toString());
//        System.out.println(redisConfig.getJedisCluster().getClusterNodes());
//        System.out.println(jedisClientCluster.get("yp"));
//        RedisTemplate.set("123", "string");
        Long expire = redisTemplate.getExpire("key");
        return  ""+expire;
        
    }
    
    @RequestMapping(value = "getRedisTemplate")
    public String getRedisTemplate(){
//    	GenericJackson2JsonRedisSerializer
//    	empRedisTemplate.opsForValue().set(1, Foo.getStudents());
////    	System.out.println("getRedisTemplate: ==== "+Foo.getStudents());
//    	Object string = empRedisTemplate.opsForValue().get(1);
//    	Students students = new Students();
//    	if(string instanceof Students) {
//    		students = (Students) string;
//    		System.out.println("强转成功："+students.toString());
    	
    	redisUtil.set("key", "123");
//    	}
//    	System.out.println(string);
        return (String) redisUtil.get("key") ;
    }
}

