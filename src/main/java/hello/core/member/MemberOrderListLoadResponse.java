package hello.core.member;

import hello.core.item.Item;
import hello.core.order.OrderStatus;
import hello.core.order.Ordering;
import hello.core.orderitem.OrderingItem;
import lombok.*;
import org.springframework.util.CollectionUtils;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class MemberOrderListLoadResponse {
    private Long id;
    private List<MemberOrder> orderingList;

    public static MemberOrderListLoadResponse of(Member member) {

        List<Ordering> orderings = member.getOrderings();

        return MemberOrderListLoadResponse.builder()
                .id(member.getId())
                .orderingList(orderings.stream().map(MemberOrderListLoadResponse.MemberOrder::of).collect(Collectors.toList()))
                .build();
    }


    @Builder
    @Getter
    private static class MemberOrder {
        private OrderStatus orderStatus;
        private List<OrderItem> orderingItems;

        public static MemberOrder of(Ordering ordering) {
            return MemberOrder.builder()
                    .orderStatus(ordering.getOrderStatus())
                    .orderingItems(ordering.getOrderingItems().stream().map(MemberOrderListLoadResponse.OrderItem::of).collect(Collectors.toList()))
                    .build();
        }
    }

    @Builder
    @Getter
    private static class OrderItem {
        private String itemName;
        private Integer quantity;

        public static OrderItem of(OrderingItem orderingItem) {
            return OrderItem.builder()
                    .itemName(orderingItem.getItem().getName())
                    .quantity(orderingItem.getQuantity())
                    .build();
        }

    }

}
