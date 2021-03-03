package aiot.mclaren.senna.host;

import cn.hutool.crypto.SecureUtil;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lsj
 * @date 2021/2/7 18:03
 */
@SpringBootTest
public class SennaApplicationTests {

    public static void main(String[] args) {
        System.out.println(SecureUtil.hmacSha1("3b0999f3adb3ef876274296edfaaf1c2abd76acfcc48e57ac10c08088b5c1b22")
            .digestHex("mqtt-test-4"));
    }

}
