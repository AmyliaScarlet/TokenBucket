package com.amyliascarlet.demo.tokenbucket;


import com.amyliascarlet.demo.tokenbucket.config.BucketManager;
import com.amyliascarlet.demo.tokenbucket.constans.Constants;
import com.amyliascarlet.demo.tokenbucket.scheduled.BucketScheduled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EnableScheduling
@SpringBootApplication
public class TokenBucketApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenBucketApplication.class, args);

		//创建令牌桶
		for (String name: Constants.BUCKETS)
			BucketManager.getInstance().genBucket(name);

	}

	@Scheduled(fixedRate = Constants.fixedRate)
	public void timer() {
		System.out.println("=====" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "=====");
		BucketScheduled.genTokens();
	}


}
