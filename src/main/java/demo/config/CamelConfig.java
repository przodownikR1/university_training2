package demo.config;

import javax.annotation.PostConstruct;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {
    @Autowired
    CamelContext camelContext;

    @PostConstruct
    public void init() {
        System.err.println("" + camelContext.getRouteDefinitions());
    }

}