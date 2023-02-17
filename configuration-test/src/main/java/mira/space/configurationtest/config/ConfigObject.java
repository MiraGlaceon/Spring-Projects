package mira.space.configurationtest.config;

import mira.space.configurationtest.component.BeanObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("mira.space.configurationtest.component")
public class ConfigObject {

    @Bean
    public BeanObject getBeanObject(){
        /* This is method of bean-creation useful when we take external classes
         like from other libraries, or we want to manage object before return */
        return new BeanObject("annotated with the @Bean");
    }

}
