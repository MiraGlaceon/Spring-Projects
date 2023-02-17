package mira.space.configurationtest.beantest;

import mira.space.configurationtest.component.BeanObject;
import mira.space.configurationtest.component.ComponentObject;
import mira.space.configurationtest.config.ConfigObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest // allows use container to autowired
public class BeanTest {

    @Autowired
    private BeanObject bean;

    @Test
    public void beanTest() {
        ApplicationContext appBeans = new AnnotationConfigApplicationContext(ConfigObject.class);
        ComponentObject component = appBeans.getBean(ComponentObject.class);
        //BeanObject bean = appBeans.getBean(BeanObject.class);

        Assertions.assertNotNull(component);
        Assertions.assertNotNull(bean);
    }

}
