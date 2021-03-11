package aiot.mclaren.senna.host.config;

import com.ling5821.emqx.EmqxConfig;
import com.ling5821.emqx.EmqxHttpClient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lsj
 * @date 2021/3/8 20:50
 */
@Configuration
@ConfigurationProperties(prefix = "broker")
public class BrokerConfig {
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;


    private EmqxConfig emqxConfig() {
        EmqxConfig config = new EmqxConfig();
        config.setAddress(this.address);
        config.setUsername(this.username);
        config.setPassword(this.password);
        return config;
    }

    @Bean
    public EmqxHttpClient emqxHttpClient() {
        return new EmqxHttpClient(emqxConfig());
    }

}
