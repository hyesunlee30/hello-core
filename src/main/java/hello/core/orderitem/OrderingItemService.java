package hello.core.orderitem;

import hello.core.order.Ordering;
import hello.core.order.OrderingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class OrderingItemService {

    private final OrderingItemRepository repository;

    public OrderingItemService(OrderingItemRepository repository) {
        this.repository = repository;

    }

    public List<OrderingItemListResponse> findAll(Long id) {

        List<OrderingItem> orderingItemList =repository.findByOrderingId(id);
        return orderingItemList.stream().map(OrderingItemListResponse::of).collect(Collectors.toList());
    }
}
