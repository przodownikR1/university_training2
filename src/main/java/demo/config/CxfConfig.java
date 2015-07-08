package demo.config;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
@Configurable
public class CxfConfig {
    @Bean
    public ServletRegistrationBean soapServletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CXFServlet(), "/soap/*");
        registration.setName("CXFServlet");
        return registration;
    }

    @Bean
    Bus cxf() {
        return BusFactory.newInstance().createBus();
    }
}
