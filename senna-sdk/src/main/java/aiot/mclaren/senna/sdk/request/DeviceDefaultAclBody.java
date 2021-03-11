package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lsj
 * @date 2021/3/8 18:25
 */
@ApiModel("默认ACL初始化请求参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDefaultAclBody {
    private String productKey;
    private String deviceName;
    private String username;
}
