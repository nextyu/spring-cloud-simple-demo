package com.nextyu;

import com.nextyu.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created on 2017-05-27 14:38
 *
 * @author nextyu
 */
@Configuration
public class FilterConfig {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
