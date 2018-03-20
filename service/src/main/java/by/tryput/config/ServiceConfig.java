package by.tryput.config;

import by.tryput.repositories.config.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
@EnableTransactionManagement
@ComponentScan("by.tryput.services")
@Import(value = {PersistenceConfig.class, AspectConfig.class})
public class ServiceConfig {
}
