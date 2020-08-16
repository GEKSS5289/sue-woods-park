
package com.sue.rabbit.producer.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(RabbitProducerDataSourceConfiguration.class)
public class RabbitProducerMybatisMapperScanerConfig {
	
	@Bean(name="rabbitProducerMapperScannerConfigurer")
    public MapperScannerConfigurer rabbitProducerMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("rabbitProducerSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.sue.rabbit.producer.mapper");
        return mapperScannerConfigurer;
    }

}
