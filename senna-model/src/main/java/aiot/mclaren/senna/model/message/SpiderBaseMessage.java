package aiot.mclaren.senna.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lsj
 * @date 2021/2/23 22:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpiderBaseMessage {
    private String id;
    private String version;
}
