package by.tryput.config;

import by.tryput.aspect.ServiceLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public ServiceLogger serviceLoggerAspect() {
        return new ServiceLogger();
    }
}
