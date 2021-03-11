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
 * @since 2021-02-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 品类键
     */
    private String categoryKey;

    /**
     * 品类名称
     */
    private String categoryName;

    /**
     * 父级ID
     */
    private Long superId;


}
