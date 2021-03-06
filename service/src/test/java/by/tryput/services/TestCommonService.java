package by.tryput.services;


import by.tryput.config.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;


@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class TestCommonService {

    @Autowired
    CommonService commonService;

    @Test
    public void test() {
        commonService.findAllPageable(1, 5).forEach(System.out::println);

    }
}
