package springboot.mysql;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcDemo {
	
	@Resource    // 自动注入，spring boot会帮我们实例化一个对象
    private JdbcTemplate jdbcTemplate;   // 一个通过JDBC连接数据库的工具类，可以通过这个工具类对数据库进行增删改查

	
}
