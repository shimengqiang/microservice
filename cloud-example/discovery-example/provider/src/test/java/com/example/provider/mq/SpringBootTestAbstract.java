package com.example.provider.mq;

import com.example.provider.ProviderApp;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProviderApp.class)
// @ActiveProfiles("dev")
@WebAppConfiguration
@TestPropertySource({//引用的配置文件
        "classpath:/application.properties"
})
public class SpringBootTestAbstract {
}
    