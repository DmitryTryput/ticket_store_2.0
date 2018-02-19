package by.tryput.config;

import by.tryput.repositories.config.PersistenceConfig;
import by.tryput.services.CommonService;
import by.tryput.services.CommonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
@EnableTransactionManagement
public class ServicesConfig extends PersistenceConfig{

    @Bean
    public CommonService commonService() {
        return new CommonServiceImpl();
    }

}
