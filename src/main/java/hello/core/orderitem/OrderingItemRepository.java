package hello.core.orderitem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingItemRepository extends JpaRepository<OrderingItem, Long> {
}
