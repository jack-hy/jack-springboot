package cn.jiangdoc;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class ConnectReidsCluster {

	public static void main(String[] args) throws IOException {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
	    // 最大连接数
	    poolConfig.setMaxTotal(1000);
	    // 最大空闲数
	    poolConfig.setMaxIdle(100);
	    // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
	    poolConfig.setMaxWaitMillis(1000);
	    
	    Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
 
	    nodes.add(new HostAndPort("idyll.life", 8001));		//idyll.life在这里只是作填充
	    nodes.add(new HostAndPort("idyll.life", 8002));
	    nodes.add(new HostAndPort("idyll.life", 8003));
	    nodes.add(new HostAndPort("idyll.life", 8004));
	    nodes.add(new HostAndPort("idyll.life", 8005));
	    nodes.add(new HostAndPort("idyll.life", 8006));		//ip填写服务器的ip地址 
	    JedisCluster cluster = new JedisCluster(nodes, 1000, 1000, 1, "redis123", poolConfig);
	    
	    String name = cluster.get("name");
	    System.out.println(name);
	    cluster.set("info", "我很快乐");
	    System.out.println(cluster.get("info"));
	    cluster.close();

	}
}
