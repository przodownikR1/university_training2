package demo.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableWebMvc
@Slf4j
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    /*
     * @Bean
     * public InternalResourceViewResolver internalResourceViewResolver() {
     * InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
     * viewResolver.setPrefix("/WEB-INF/templates/");
     * viewResolver.setSuffix(".jsp");
     * log.info(":: internalResourceViewResolver");
     * return viewResolver;
     * }
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("WEB-INF/static/favicon.ico");
        registry.addResourceHandler("/js/**").addResourceLocations("WEB-INF/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("WEB-INF/css/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        super.addInterceptors(registry);
    }

    @Bean(name = AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver clr = new CookieLocaleResolver();
        return clr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
}
