package com.study.sbautoconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/10/20 01:20
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "ke.config")
public class AutoConfigProperties {

    private String firstName = "ke";

    private String lastName = "mengjian";

    public AutoConfigProperties(AutoConfigProperties props) {
        this.firstName = props.getFirstName();
        this.lastName = props.getLastName();
    }

    public AutoConfigProperties() {
    }
}
