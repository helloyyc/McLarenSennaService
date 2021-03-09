package aiot.mclaren.senna.host;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author lsj
 * @date 2021/3/9 12:03
 */
@SpringBootTest
public class OssTest {
    @Autowired
    private OSS oss;



    @Test
    void simpleUpload() {
        String content = "{\"NewWeight\":100.8}";

//        PutObjectRequest request = new PutObjectRequest("jsmb", "thing/hello.json", new ByteArrayInputStream(content.getBytes(
//            StandardCharsets.UTF_8)));
//        PutObjectResult putObjectResult = oss.putObject(request);
//        System.out.println(putObjectResult);
//        System.out.println(putObjectResult.getVersionId());
//        System.out.println(putObjectResult.getResponse());
//        System.out.println(putObjectResult.getResponse().getUri());
//        OSSObject object = oss.getObject("jsmb", "thing/hello.json");
//        System.out.println(object.toString());

    }
}
