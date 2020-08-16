package com.sue.rabbit.producer.autoconfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author sue
 * @date 2020/8/15 17:05
 */

/**
 * 自动装配
 */
@Configuration
@ComponentScan("com.sue.rabbit.producer.*")
public class RabbitProducerAutoConfiguration {
}
