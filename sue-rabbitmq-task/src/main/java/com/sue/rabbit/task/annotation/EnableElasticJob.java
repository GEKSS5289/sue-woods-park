package com.sue.rabbit.task.annotation;

import com.sue.rabbit.task.autoconfiguration.JobParserAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author sue
 * @date 2020/8/16 13:55
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(JobParserAutoConfiguration.class)
public @interface EnableElasticJob {
}
