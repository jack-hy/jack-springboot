package cn.jiangdoc;

import java.util.LinkedHashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
 * @author jiangdoc
 *
 */
public class JedisUtil {
	public static void main(String[] args) {
	//ip地址，端口号
		JedisCluster jedis_cli_pool = cli_pool("idyll.life", 8003);
		jedis_cli_pool.set("jedis_cli_pool", "jedis_cli_pool");		
		String value2 = jedis_cli_pool.get("jedis_cli_pool");
		System.out.println(value2);
		
//		Jedis jedis_cli_single = cli_single("idyll.life", 8001);
//		jedis_cli_single.set("jedis_cli_single", "jedis_cli_single");
//		String value = jedis_cli_single.get("jedis_cli_single");
//		System.out.println(value);
		
	}

	/**
	 * 单个连接
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public static Jedis cli_single(String host, int port) {
		try {
			return new Jedis(host, port);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 连接池
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public static JedisCluster cli_pool(String host, int port) {
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大连接数
		config.setMaxTotal(10);
		// 最大连接空闲数
		config.setMaxIdle(2);
		Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
	    nodes.add(new HostAndPort(host, port));		//idyll.life在这里只是作填充
		
		JedisCluster JedisCluster = new JedisCluster(nodes, 1000, 1000, 1, "redis123", config);
		try{
			return JedisCluster;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}
}

