package com.study.sbautoconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/10/20 01:23
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(AutoConfigProperties.class)
public class AutoConfigAutoConfiguration {

    @Bean
    public AutoConfigProperties getAutoConfigProperties(AutoConfigProperties props){
        log.info("ke.config.firstName = [{}];",props.getFirstName());
        log.info("ke.config.lastName = [{}];",props.getLastName());
        return new AutoConfigProperties(props);
    }

}
