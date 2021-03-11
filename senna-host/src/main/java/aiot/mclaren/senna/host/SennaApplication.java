package aiot.mclaren.senna.host;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhiwen.zuo
 * @date 2021-01-29
 **/
@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
@ComponentScan(basePackages = "aiot.mclaren")
public class SennaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SennaApplication.class, args);
    }
}
