package mira.space.configurationtest.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentObject {

    private String field;

    public ComponentObject(String field) {
        this.field = field;
    }

    /**
     * Zero params constructor needed for bean-creation with AppContext
     * if we use ComponentScan annotation on configuration class
     * */
    public ComponentObject() {
        this.field = "annotated with the @Component";
    }
}
