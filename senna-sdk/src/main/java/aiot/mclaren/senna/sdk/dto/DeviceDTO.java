package aiot.mclaren.senna.sdk.dto;

import lombok.Data;

/**
 * @author lsj
 * @date 2021/3/3 15:40
 */
@Data
public class DeviceDTO {
    private String iotId;
    private String productKey;
    private String deviceName;
    private String deviceSecret;
    private String nickName;
    private String deviceDescription;
}
