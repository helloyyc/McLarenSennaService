package aiot.mclaren.senna.host;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhiwen.zuo
 * @date 2021-01-29
 **/
@SpringBootApplication
@EnableTransactionManagement
public class SennaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SennaApplication.class, args);
    }
}
