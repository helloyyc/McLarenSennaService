package aiot.mclaren.senna.host.common;

import cn.hutool.crypto.SecureUtil;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author lsj
 * @date 2021/2/7 10:15
 */
public class SecurityUtils {
    private final static String[] CHARS = new String[]{"a", "b", "c", "d", "e", "f",
        "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
        "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
        "W", "X", "Y", "Z"};


    public static String getSecretId() {
        return getShortId(11);

    }

    /**
     * @Description: <p>
     * 短8位UUID思想其实借鉴微博短域名的生成方式，但是其重复概率过高，而且每次生成4个，需要随即选取一个。
     * 本算法利用62个可打印字符，通过随机生成32位UUID，由于UUID都为十六进制，所以将UUID分成8组，每4个为一组，然后通过模62操作，结果作为索引取出字符，
     * 这样重复率大大降低。
     * 经测试，在生成一千万个数据也没有出现重复，完全满足大部分需求。
     * </p>
     *
     */
    public static String getShortId(int size) {
        StringBuilder shortBuilder = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < size; i++) {
            String str = uuid.substring(i * 2, i * 2 + 2);
            int x = Integer.parseInt(str, 16);
            shortBuilder.append(CHARS[x % 0x3E]);
        }
        return shortBuilder.toString();
    }


    /**
     * <p>
     * 通过appKey Secret
     * </P>
     */
    public static String getSecretKey(String secretId, String entityKeyWord) {
        String[] array = new String[]{secretId, entityKeyWord, UUID.randomUUID().toString()};
        StringBuilder sb = new StringBuilder();
        // 字符串排序
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        return SecureUtil.sha256(sb.toString());
        /*try {


            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(sb.toString().getBytes());
            byte[] digest = md.digest();

            StringBuilder hexstr = new StringBuilder();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }*/
    }

    public static String getSalt() {
        return getShortId(8);
    }

    public static String getPasswordHash(String password, String salt) {
        return SecureUtil.sha256(password + salt);
    }
}
