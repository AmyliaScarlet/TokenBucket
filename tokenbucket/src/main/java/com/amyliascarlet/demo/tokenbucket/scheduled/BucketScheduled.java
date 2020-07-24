package com.amyliascarlet.demo.tokenbucket.scheduled;

import com.amyliascarlet.demo.tokenbucket.config.BucketManager;
import com.amyliascarlet.demo.tokenbucket.constans.Constants;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BucketScheduled {

    public static void genTokens(){
        for (String name:Constants.BUCKETS)
            BucketManager.getInstance().getBucket(name).genTokens();
    }
}
