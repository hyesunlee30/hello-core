package hello.core.orderitem;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderingItemListResponse {

    private String itemName;
    private Integer quantity;
    private Long orderingId;


    public static OrderingItemListResponse of(OrderingItem orderingItem) {
        return OrderingItemListResponse.builder()
                .itemName(orderingItem.getItem().getName())
                .quantity(orderingItem.getQuantity())
                .orderingId(orderingItem.getOrdering().getId())
                .build();
    }
}
