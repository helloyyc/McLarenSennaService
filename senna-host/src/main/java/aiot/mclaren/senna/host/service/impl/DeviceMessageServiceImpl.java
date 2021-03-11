package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.senna.host.common.JsonUtils;
import aiot.mclaren.senna.host.service.IDeviceMessageService;
import aiot.mclaren.senna.model.constant.SysTopicConst;
import aiot.mclaren.senna.model.message.SpiderRequest;
import aiot.mclaren.senna.sdk.request.InvokeServiceBody;
import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.ling5821.emqx.EmqxHttpClient;
import com.ling5821.emqx.model.MqttMessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author lsj
 * @date 2021/3/8 20:33
 */
@Service
public class DeviceMessageServiceImpl implements IDeviceMessageService {

    @Autowired
    private EmqxHttpClient emqxHttpClient;

    @Override
    public boolean invokeService(InvokeServiceBody body) {
        String topic = String
            .format(SysTopicConst.SERVICE_CALL_PUBLISH_FORMAT, body.getProductKey(), body.getDeviceName(),
                body.getIdentifier());
        MqttMessageBody mqttMessageBody = new MqttMessageBody();
        mqttMessageBody.setTopic(topic);
        mqttMessageBody.setClientid("iot-server-pub-" + RandomUtil.randomString(20));
        mqttMessageBody.setQos(1);
        SpiderRequest<Object> request = new SpiderRequest<>(Instant.now().toEpochMilli(),
            JsonUtils.fromJson(body.getArgs(), new TypeReference<Map<String, Object>>() {
            }), "thing.service." + body.getIdentifier());
        mqttMessageBody.setPayload(JsonUtils.toJson(request));
        return emqxHttpClient.publish(mqttMessageBody);
    }
}
