package aiot.mclaren.senna.sdk.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author lsj
 * @date 2021/2/22 15:09
 */
@Data
@ApiModel("分页信息")
public class PageList<T> {
    @ApiModelProperty("记录数据")
    private List<T> records;
    @ApiModelProperty("总记录数")
    private long total;
    @ApiModelProperty("每页条数")
    private long size;
    @ApiModelProperty("当前页")
    private long current;
    @ApiModelProperty("总页数")
    private long pages;
}
