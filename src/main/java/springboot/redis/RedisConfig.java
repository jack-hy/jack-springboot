package springboot.redis;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPoolConfig;

/**
    * @Title: RedisConfig
    * @ProjectName springbootdemo
    * @Description: TODO
    * @author YangPeng
    * @date 2019/4/3-18:17
    */
@Configuration
public class RedisConfig {

	@Autowired
    private RedisTemplate redisTemplate;
	
//    @Autowired
//    private RedisProperties redisProperties;
    
//    @Autowired
//    private JedisPoolConfig poolConfig;
    
//    @Bean
//    public RedisConnectionFactory connectionFactory() {
//        JedisPoolConfig poolConfig1 = new JedisPoolConfig();
//        poolConfig1.setMaxTotal(8);
//        poolConfig1.setMaxIdle(8);
//        poolConfig1.setMaxWaitMillis(1000);
//        poolConfig1.setMinIdle(8);
//        poolConfig1.setTestOnBorrow(true);
//        poolConfig1.setTestOnReturn(false);
//        poolConfig1.setTestWhileIdle(true);
////        JedisClientConfiguration clientConfig = JedisClientConfiguration.builder()
////                .usePooling().poolConfig(poolConfig).and().readTimeout(Duration.ofMillis(redisTimeout)).build();
////        JedisPoolConfig poolConfig
//        // 单点redis
////        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
//        // 哨兵redis
//        // RedisSentinelConfiguration redisConfig = new RedisSentinelConfiguration();
//        // 集群redis
//        
////        redis.clients.jedis.JedisPoolConfig
//        RedisClusterConfiguration redisConfig = new RedisClusterConfiguration();
////        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
//        new org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration();
//        return new JedisConnectionFactory(redisConfig,poolConfig);
//    }
    
    

    
    
//    @Bean
//    public JedisCluster getJedisCluster(){
//        //获取redis集群的ip及端口号等相关信息；
//        String[] serverArray = redisProperties.getNodes().split(",");
//        
//        Set<HostAndPort> nodes = new HashSet<>();
//        //遍历add到HostAndPort中；
//        for (String ipPort : serverArray) {
//            String[] ipPortPair = ipPort.split(":");
//            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
//        }
//        String password = redisProperties.getPassword();
//        System.out.println(password);
//        //构建对象并返回；
//        return new JedisCluster(nodes ,redisProperties.getCommandTimeout(), redisProperties.getSoTimeout(),
//        		redisProperties.getMaxAttempts(), password, poolConfig);
////        return new JedisCluster(nodes, redisProperties.getCommandTimeout());
//    }
    
    public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	@Bean
    public RedisTemplate<Object, Object> RedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
//        redisConnectionFactory.
        Jackson2JsonRedisSerializer<Object> ser = new Jackson2JsonRedisSerializer<Object>(Object.class);
        template.setDefaultSerializer(ser);
        return template;
    }
}

