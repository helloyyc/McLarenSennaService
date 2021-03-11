package aiot.mclaren.senna.model.entity;

import aiot.mclaren.senna.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductTagMapping extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 标签ID
     */
    private Long tagId;


}
