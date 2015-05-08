package demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan(basePackages="demo.repository",useDefaultFilters=false,includeFilters={@Filter(Repository.class)})
@EnableJpaRepositories(basePackages="demo.repository")
@Import(value={PropertiesLoader.class,DsConfig.class})
public class RepositoryConfig {

}
