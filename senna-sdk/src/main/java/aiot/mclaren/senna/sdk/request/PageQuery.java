package aiot.mclaren.senna.sdk.request;

import lombok.Data;

/**
 * @author lsj
 * @date 2021/2/22 13:32
 */
@Data
public class PageQuery {
    private long page = 1;
    private long size = 10;
}
