package org.py.sweb;

import org.py.sweb.sys.util.ImgUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemBeans {
    @Bean
    public ImgUtil imgUtil() {
        return new ImgUtil();
    }
}
