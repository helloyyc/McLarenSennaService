package aiot.mclaren.senna.sdk.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lsj
 * @date 2021/2/22 11:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductQuery extends PageQuery {
    private String productName;
}
