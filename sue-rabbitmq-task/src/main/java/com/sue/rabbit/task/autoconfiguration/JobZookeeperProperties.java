package com.sue.rabbit.task.autoconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author sue
 * @date 2020/8/16 13:45
 */

@Configuration
@ConfigurationProperties(prefix = "elastic.job.zk")
@Data
public class JobZookeeperProperties {
    private String namespace;

    private String serverLists;

    private int maxRetries = 3;

    private int connectionTimeoutMilliseconds = 15000;

    private int sessionTimeoutMilliseconds = 60000;

    private int baseSleepTimeMilliseconds = 1000;

    private int maxSleepTimeMilliseconds = 3000;

    private String digest = "";
}
