package hello.core.orderitem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderingItemController {

    private final OrderingItemService service;

    public OrderingItemController(OrderingItemService service) {
        this.service = service;
    }

    @GetMapping("/orderitems/{id}")
    public List<OrderingItemListResponse> orderingItems(@PathVariable Long id) {
        return service.findAll(id);

    }

}
