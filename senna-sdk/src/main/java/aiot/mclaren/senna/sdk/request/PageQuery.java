package aiot.mclaren.senna.sdk.request;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * @author lsj
 * @date 2021/2/22 13:32
 */
@Data
public class PageQuery {
    private long current = 1;
    private long size = 10;
    private List<OrderItem> orders;

    public <T> Page<T> toPage() {
        Page<T> page = new Page<>(this.current, this.size);
        page.setOrders(orders);
        return page;
    }
}
