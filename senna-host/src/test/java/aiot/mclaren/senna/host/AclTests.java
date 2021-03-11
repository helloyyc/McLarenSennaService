package aiot.mclaren.senna.host;

import aiot.mclaren.senna.host.service.IDeviceAclService;
import aiot.mclaren.senna.model.constant.SysTopicConst;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * @author lsj
 * @date 2021/3/4 22:08
 */
@SpringBootTest
@Slf4j
public class AclTests {
    @Autowired
    private IDeviceAclService deviceAclService;
    @Test
    void stdDefaultAclEnum() throws IllegalAccessException {
        Field[] fields = SysTopicConst.class.getFields();
        for (Field field : fields) {
            String name = field.getName();
            String out = "ACL_";
            String[] nameSplits = field.getName().split("_");
            for (int i = 0; i < nameSplits.length - 2; i++) {
                out += nameSplits[i] + "_";
            }
            String access = "";
            if (Pattern.matches(".*PUBLISH.*", name)) {
                access = "TopicAccessEnum.SUBSCRIBE";
            } else if (Pattern.matches(".*SUBSCRIBE.*", name)) {
                access = "TopicAccessEnum.PUBLISH";
            }
            out = out.substring(0, out.length() - 1);
            out += "(\"" + field.get(null) + "\", " + access + "),";
            System.out.println(out);
        }
    }

    @Test
    void initNewDeviceDefaultAclTest() {
//        String productKey = "XKwduxnFOoG";
//        String deviceName = "robot-test-1";
//        String username = "robot-test-1&XKwduxnFOoG";
//        deviceAclService.initDeviceDefaultAcl(productKey, deviceName, username);
    }

    @Test
    void initSysDefaultAcl() {
        boolean save = deviceAclService.initSysDefaultAcl();
        log.info("initSysDefaultAcl success {}", save);
    }


}
