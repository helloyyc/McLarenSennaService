package aiot.mclaren.senna.model.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lsj
 * @date 2021/2/23 20:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SpiderRequest<T> extends SpiderBaseMessage {
    private T params;
    private String method;

    public SpiderRequest(String id, String version, T params, String method) {
        super(id, version);
        this.params = params;
        this.method = method;
    }

    public SpiderRequest(Long id, T params, String method) {
        super(id + "", "1.0");
        this.params = params;
        this.method = method;
    }
}
