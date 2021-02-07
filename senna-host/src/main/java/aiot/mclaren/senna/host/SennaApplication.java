package aiot.mclaren.senna.host;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhiwen.zuo
 * @date 2021-01-29
 **/
@SpringBootApplication
@MapperScan({"aiot.mclaren.senna.host.mapper"})
public class SennaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SennaApplication.class, args);
    }
}
