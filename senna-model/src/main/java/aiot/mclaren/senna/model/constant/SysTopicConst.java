package aiot.mclaren.senna.model.constant;

import aiot.mclaren.senna.model.enums.TopicAccessEnum;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * @author lsj
 * @date 2021/2/25 16:17
 */
public class SysTopicConst {

    /* Subscribe Format Topic (设备上行) */
    /**
     * OTA 设备上报OTA模块信息
     */
    public static final String OTA_FIRMWARE_POST_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/ota/firmware/post";

    /**
     * OTA 设备上报OTA升级进度
     */
    public static final String OTA_PROGRESS_POST_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/ota/progress/post";

    /**
     * OTA 设备主动拉取固件升级信息
     */
    public static final String OTA_FIRMWARE_GET_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/ota/firmware/get";

    /**
     * TAG 设备上报标签信息
     */
    public static final String TAG_UPDATE_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/deviceinfo/update";

    /**
     * TAG 设备删除标签信息
     */
    public static final String TAG_DELETE_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/deviceinfo/delete";

    /**
     * CONFIG 设备获取配置信息
     */
    public static final String CONFIG_GET_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/config/get";

    /**
     * CONFIG 设备响应平台下推配置
     */
    public static final String CONFIG_PUSH_REPLY_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/config/push_reply";

    /**
     * LOG CONFIG 设备请求日志配置
     */
    public static final String LOG_CONFIG_GET_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/config/log/get";

    /**
     * LOG 设备上报本地日志
     */
    public static final String LOG_POST_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/log/post";

    /**
     * RAW 设备上行透传/自定义格式
     */
    public static final String RAW_UP_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/model/up_raw";

    /**
     * RAW 设备回复下行透传/自定义格式
     */
    public static final String RAW_DOWN_REPLY_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/model/down_raw_reply";

    /**
     * PROPERTY 设备上报属性格式
     */
    public static final String PROPERTY_POST_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/event/property/post";

    /**
     * PROPERTY 设备响应属性设置格式
     */
    public static final String PROPERTY_SET_REPLY_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/service/property/call_reply";

    /**
     * EVENT 设备事件上报格式
     */
    public static final String EVENT_POST_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/event/+/post";

    /**
     * SERVICE 设备响应服务调用格式
     */
    public static final String SERVICE_CALL_REPLY_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/service/+/call_reply";

    /**
     * TSL 设备请求物模型模板格式
     */
    public static final String TSL_GET_TOPIC_SUBSCRIBE_FORMAT = "/sys/%s/%s/thing/dsltemplate/get";


    /* Publish Topic Format(平台下行) */

    /**
     * OTA 平台推送升级包信息主题格式
     */
    public static final String OTA_FIRMWARE_PUSH_TOPIC_PUBLISH_FORMAT = "/sys/%s/%s/thing/ota/firmware/push";

    /**
     * OTA 平台响应固件升级信息
     */
    public static final String OTA_FIRMWARE_GET_REPLY_TOPIC_PUBLISH_FORMAT = "/sys/%s/%s/thing/ota/firmware/get_reply";

    /**
     * TAG 平台响应标签上报主题格式
     */
    public static final String TAG_UPDATE_REPLY_PUBLISH_FORMAT = "/sys/%s/%s/thing/deviceinfo/update_reply";

    /**
     * TAG 平台响应标签删除主题格式
     */
    public static final String TAG_DELETE_REPLY_PUBLISH_FORMAT = "/sys/%s/%s/thing/deviceinfo/delete_reply";

    /**
     * CONFIG 平台响应设备配置主题格式
     */
    public static final String CONFIG_GET_REPLY_PUBLISH_FORMAT = "/sys/%s/%s/thing/config/get_reply";

    /**
     * CONFIG 平台推送配置信息主题格式
     */
    public static final String CONFIG_PUSH_PUBLISH_FORMAT = "/sys/%s/%s/thing/config/push";

    /**
     * LOG 平台响应日志配置主题格式
     */
    public static final String LOG_CONFIG_GET_REPLY_PUBLISH_FORMAT = "/sys/%s/%s/thing/config/log/get_reply";

    /**
     * LOG 平台推送日志配置主题格式
     */
    public static final String LOG_CONFIG_PUSH_PUBLISH_FORMAT = "/sys/%s/%s/thing/config/log/push";

    /**
     * LOG 平台响应日志上报主题格式
     */
    public static final String LOG_POST_REPLY_PUBLISH_FORMAT = "/sys/%s/%s/thing/log/post_reply";

    /**
     * RAW 平台响应透传/自定义主题格式
     */
    public static final String RAW_UP_REPLY_PUBLISH_FORMAT = "/sys/%s/%s/thing/model/up_raw_reply";

    /**
     * RAW 平台推送透传/自定义主题格式
     */
    public static final String RAW_DOWN_PUBLISH_FORMAT = "/sys/%s/%s/thing/model/down_raw";

    /**
     * PROPERTY 平台响应属性上报主题格式
     */
    public static final String PROPERTY_POST_REPLY_PUBLISH_FORMAT = "/sys/%s/%s/thing/event/property/post_reply";

    /**
     * PROPERTY 平台设置设备属性主题格式
     */
    public static final String PROPERTY_SET_PUBLISH_FORMAT = "/sys/%s/%s/thing/service/property/call";

    /**
     * EVENT 平台响应设备事件上报主题格式
     */
    public static final String EVENT_POST_REPLY_PUBLISH_FORMAT = "/sys/%s/%s/thing/event/%s/post_reply";

    /**
     * SERVICE 平台下发服务调用主题格式
     */
    public static final String SERVICE_CALL_PUBLISH_FORMAT = "/sys/%s/%s/thing/service/%s/call";

    /**
     * TSL 平台响应物模型模板主题格式
     */
    public static final String TSL_GET_REPLY_PUBLISH_FORMAT = "/sys/%s/%s/thing/dsltemplate/get_reply";

    public static final String[] ALL_TOPIC_FORMAT = {
        OTA_FIRMWARE_POST_SUBSCRIBE_FORMAT,
        OTA_PROGRESS_POST_SUBSCRIBE_FORMAT,
        OTA_FIRMWARE_GET_SUBSCRIBE_FORMAT,
        TAG_UPDATE_SUBSCRIBE_FORMAT,
        TAG_DELETE_SUBSCRIBE_FORMAT,
        CONFIG_GET_SUBSCRIBE_FORMAT,
        CONFIG_PUSH_REPLY_SUBSCRIBE_FORMAT,
        LOG_CONFIG_GET_SUBSCRIBE_FORMAT,
        LOG_POST_SUBSCRIBE_FORMAT,
        RAW_UP_SUBSCRIBE_FORMAT,
        RAW_DOWN_REPLY_SUBSCRIBE_FORMAT,
        PROPERTY_POST_SUBSCRIBE_FORMAT,
        PROPERTY_SET_REPLY_SUBSCRIBE_FORMAT,
        EVENT_POST_SUBSCRIBE_FORMAT,
        SERVICE_CALL_REPLY_SUBSCRIBE_FORMAT,
        TSL_GET_TOPIC_SUBSCRIBE_FORMAT,
        OTA_FIRMWARE_PUSH_TOPIC_PUBLISH_FORMAT,
        OTA_FIRMWARE_GET_REPLY_TOPIC_PUBLISH_FORMAT,
        TAG_UPDATE_REPLY_PUBLISH_FORMAT,
        TAG_DELETE_REPLY_PUBLISH_FORMAT,
        CONFIG_GET_REPLY_PUBLISH_FORMAT,
        CONFIG_PUSH_PUBLISH_FORMAT,
        LOG_CONFIG_GET_REPLY_PUBLISH_FORMAT,
        LOG_CONFIG_PUSH_PUBLISH_FORMAT,
        LOG_POST_REPLY_PUBLISH_FORMAT,
        RAW_UP_REPLY_PUBLISH_FORMAT,
        RAW_DOWN_PUBLISH_FORMAT,
        PROPERTY_POST_REPLY_PUBLISH_FORMAT,
        PROPERTY_SET_PUBLISH_FORMAT,
        EVENT_POST_REPLY_PUBLISH_FORMAT,
        SERVICE_CALL_PUBLISH_FORMAT,
        TSL_GET_REPLY_PUBLISH_FORMAT
    };
}
