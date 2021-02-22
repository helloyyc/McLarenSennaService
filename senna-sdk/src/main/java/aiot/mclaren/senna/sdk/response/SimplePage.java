package aiot.mclaren.senna.sdk.response;

import lombok.Data;

import java.util.List;

/**
 * @author lsj
 * @date 2021/2/22 15:09
 */
@Data
public class SimplePage<T> {
    private List<T> records;
    private long total;
    private long size;
    private long current;
    private long pages;
}
