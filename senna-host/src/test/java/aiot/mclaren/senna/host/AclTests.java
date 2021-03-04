package aiot.mclaren.senna.host;

import aiot.mclaren.senna.model.constant.SysTopicConst;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * @author lsj
 * @date 2021/3/4 22:08
 */
@SpringBootTest
public class AclTests {
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
                access = "TopicAccessEnum.PUBLISH";
            } else if (Pattern.matches(".*SUBSCRIBE.*", name)) {
                access = "TopicAccessEnum.SUBSCRIBE";
            }
            out = out.substring(0, out.length() - 1);
            out += "(\"" + field.get(null) + "\", " + access + "),";
            System.out.println(out);
        }
    }
}
