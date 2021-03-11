package aiot.mclaren.senna.host;

import aiot.mclaren.commons.oss.OssService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author lsj
 * @date 2021/3/9 12:03
 */
@SpringBootTest
public class OssTest {
    @Autowired
    private OssService ossService;

    @Test
    void ossServiceTest() {
//        String content = "{\"NewWeight\":100.8, \"Text\": \"哈哈\"}";
//        System.out.println(ossService.uploadFile("jsmb", "thing/testUploadFile.json",
//            new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8))));
//        System.out.println(ossService.getFileUrl("jsmb", "thing/testUploadFile.json"));
//        System.out.println("---------");
//
//        System.out.println(ossService.uploadFile("thing/testUploadFile2.txt",
//            new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8))));
//        System.out.println(ossService.getFileUrl("thing/testUploadFile2.txt"));
//        System.out.println("---------");
//
//        System.out.println(ossService.uploadObject("jsmb", "thing/testUploadObject.txt",
//            new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null));
//        System.out.println(ossService.getObjectUrl("jsmb", "thing/testUploadObject.txt"));
//        System.out.println("---------");
//
//        System.out.println(ossService.uploadObject("thing/testUploadObject2.txt",
//            new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null));
//        System.out.println(ossService.getObjectUrl("thing/testUploadObject2.txt"));
//        System.out.println("---------");


    }
}
