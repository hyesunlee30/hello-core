package hello.core.order;

import hello.core.member.Member;
import hello.core.orderitem.OrderingItem;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
public class OrderingListLoadResponse {
    private Long id;
    private Long memberId;
    private List<OrderingItem> orderingItems;

    public static OrderingListLoadResponse of(Ordering ordering) {
        return OrderingListLoadResponse.builder()
                .id(ordering.getId())
                .memberId(ordering.getMember().getId())
                .orderingItems(ordering.getOrderingItems())
                .build();
    }
}
