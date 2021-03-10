package aiot.mclaren.senna.host.common;

import cn.hutool.core.util.RandomUtil;

import java.time.Instant;

/**
 * @author lsj
 * @date 2021/3/10 10:14
 */
public class OssKeyUtil {
    public static final String OSS_KEY_PREFIX = "iot/";

    public static String getKey(String productKey, String mod) {
        return OSS_KEY_PREFIX + productKey + "/" + mod + "/" + Instant.now().toEpochMilli() + "_" + RandomUtil
            .randomString(8);
    }
}
