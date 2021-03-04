package aiot.mclaren.senna.model.enums;

import lombok.Getter;

/**
 * @author lsj
 * @date 2021/3/4 21:47
 */
@Getter
public enum DefaultAclEnum {
    /**
     * 默认设备ACL模板
     */
    ACL_OTA_FIRMWARE_POST("/sys/%s/%s/thing/ota/firmware/post", TopicAccessEnum.SUBSCRIBE),
    ACL_OTA_PROGRESS_POST("/sys/%s/%s/thing/ota/progress/post", TopicAccessEnum.SUBSCRIBE),
    ACL_OTA_FIRMWARE_GET("/sys/%s/%s/thing/ota/firmware/get", TopicAccessEnum.SUBSCRIBE),
    ACL_TAG_UPDATE("/sys/%s/%s/thing/deviceinfo/update", TopicAccessEnum.SUBSCRIBE),
    ACL_TAG_DELETE("/sys/%s/%s/thing/deviceinfo/delete", TopicAccessEnum.SUBSCRIBE),
    ACL_CONFIG_GET("/sys/%s/%s/thing/config/get", TopicAccessEnum.SUBSCRIBE),
    ACL_CONFIG_PUSH_REPLY("/sys/%s/%s/thing/config/push_reply", TopicAccessEnum.SUBSCRIBE),
    ACL_LOG_CONFIG_GET("/sys/%s/%s/thing/config/log/get", TopicAccessEnum.SUBSCRIBE),
    ACL_LOG_POST("/sys/%s/%s/thing/log/post", TopicAccessEnum.SUBSCRIBE),
    ACL_RAW_UP("/sys/%s/%s/thing/model/up_raw", TopicAccessEnum.SUBSCRIBE),
    ACL_RAW_DOWN_REPLY("/sys/%s/%s/thing/model/down_raw_reply", TopicAccessEnum.SUBSCRIBE),
    ACL_PROPERTY_POST("/sys/%s/%s/thing/event/property/post", TopicAccessEnum.SUBSCRIBE),
    ACL_PROPERTY_SET_REPLY("/sys/%s/%s/thing/service/property/call_reply", TopicAccessEnum.SUBSCRIBE),
    ACL_EVENT_POST("/sys/%s/%s/thing/event/+/post", TopicAccessEnum.SUBSCRIBE),
    ACL_SERVICE_CALL_REPLY("/sys/%s/%s/thing/service/+/call_reply", TopicAccessEnum.SUBSCRIBE),
    ACL_TSL_GET_TOPIC("/sys/%s/%s/thing/dsltemplate/get", TopicAccessEnum.SUBSCRIBE),
    ACL_OTA_FIRMWARE_PUSH_TOPIC("/sys/%s/%s/thing/ota/firmware/push", TopicAccessEnum.PUBLISH),
    ACL_OTA_FIRMWARE_GET_REPLY_TOPIC("/sys/%s/%s/thing/ota/firmware/get_reply", TopicAccessEnum.PUBLISH),
    ACL_TAG_UPDATE_REPLY("/sys/%s/%s/thing/deviceinfo/update_reply", TopicAccessEnum.PUBLISH),
    ACL_TAG_DELETE_REPLY("/sys/%s/%s/thing/deviceinfo/delete_reply", TopicAccessEnum.PUBLISH),
    ACL_CONFIG_GET_REPLY("/sys/%s/%s/thing/config/get_reply", TopicAccessEnum.PUBLISH),
    ACL_CONFIG_PUSH("/sys/%s/%s/thing/config/push", TopicAccessEnum.PUBLISH),
    ACL_LOG_CONFIG_GET_REPLY("/sys/%s/%s/thing/config/log/get_reply", TopicAccessEnum.PUBLISH),
    ACL_LOG_CONFIG_PUSH("/sys/%s/%s/thing/config/log/push", TopicAccessEnum.PUBLISH),
    ACL_LOG_POST_REPLY("/sys/%s/%s/thing/log/post_reply", TopicAccessEnum.PUBLISH),
    ACL_RAW_UP_REPLY("/sys/%s/%s/thing/model/up_raw_reply", TopicAccessEnum.PUBLISH),
    ACL_RAW_DOWN("/sys/%s/%s/thing/model/down_raw", TopicAccessEnum.PUBLISH),
    ACL_PROPERTY_POST_REPLY("/sys/%s/%s/thing/event/property/post_reply", TopicAccessEnum.PUBLISH),
    ACL_PROPERTY_SET("/sys/%s/%s/thing/service/property/call", TopicAccessEnum.PUBLISH),
    ACL_EVENT_POST_REPLY("/sys/%s/%s/thing/event/+/post_reply", TopicAccessEnum.PUBLISH),
    ACL_SERVICE_CALL("/sys/%s/%s/thing/service/+/call", TopicAccessEnum.PUBLISH),
    ACL_TSL_GET_REPLY("/sys/%s/%s/thing/dsltemplate/get_reply", TopicAccessEnum.PUBLISH),
    ;

    private final String topicFormat;
    private final TopicAccessEnum access;

    DefaultAclEnum(String topicFormat, TopicAccessEnum access) {
        this.topicFormat = topicFormat;
        this.access = access;
    }
}
