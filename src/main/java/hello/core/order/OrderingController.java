package hello.core.order;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderingController {
    private final OrderingService service;

    public OrderingController(OrderingService service) {
        this.service = service;
    }

    @GetMapping("/orders")
    public List<OrderingListLoadResponse> loadOrderList() {
        return service.loadOrderList();
    }

    @PostMapping("/order/new")
    public String save(@RequestBody OrderingSaveRequest request) {
        service.save(request);
        return "OK";
    }

    @DeleteMapping("/order/{id}/cancel")
    public String cancel (@PathVariable Long id) {
        service.cancel(id);
        return "OK";
    }
}
