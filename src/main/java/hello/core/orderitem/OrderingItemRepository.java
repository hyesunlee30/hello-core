package hello.core.orderitem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderingItemRepository extends JpaRepository<OrderingItem, Long> {
    List<OrderingItem> findByOrderingId(Long id);
}
