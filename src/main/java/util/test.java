package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class test {
	
	@Autowired
	static RedisTemplate redisTemplate;
	
	
public static void main(String[] args) {
	
	putDataToRedis();
	gettDataToRedis();
}

public static void putDataToRedis() {
	System.out.println("插入key为LiaoXingGuang的数据");

	redisTemplate.opsForValue().set("LiaoXingGuang","Cool_boy~");
}

public static void gettDataToRedis() {
	String info = (String) redisTemplate.opsForValue().get("LiaoXingGuang");
	System.out.println("取出数据为：" + info);
}

}
