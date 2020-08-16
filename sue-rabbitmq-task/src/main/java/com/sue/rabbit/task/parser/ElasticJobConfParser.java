package com.sue.rabbit.task.parser;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.sue.rabbit.task.autoconfiguration.JobZookeeperProperties;

/**
 * @author sue
 * @date 2020/8/16 14:08
 */

public class ElasticJobConfParser {
    private JobZookeeperProperties jobZookeeperProperties;

    private ZookeeperRegistryCenter zookeeperRegistryCenter;

    public ElasticJobConfParser(JobZookeeperProperties jobZookeeperProperties,
                                ZookeeperRegistryCenter zookeeperRegistryCenter) {
        this.jobZookeeperProperties = jobZookeeperProperties;
        this.zookeeperRegistryCenter = zookeeperRegistryCenter;
    }
}
