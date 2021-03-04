package aiot.mclaren.senna.sdk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lsj
 * @date 2021/2/6 17:09
 */
@Data
@ApiModel("通用信息")
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createDt;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateDt;
}
