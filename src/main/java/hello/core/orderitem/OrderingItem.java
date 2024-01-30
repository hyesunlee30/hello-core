package hello.core.orderitem;

import hello.core.common.BaseTimeEntity;
import hello.core.item.Item;
import hello.core.order.Ordering;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor // 리플렉션 왜 protected 인지 정리하기
@Getter
@Setter
@Builder // 빌더
@AllArgsConstructor // 빌더
@Entity // db
public class OrderingItem extends BaseTimeEntity {
    //id, quantity, item(Item과 ManyToOne, NotNull), ordering(Ordering과 ManyToOne, NotNull)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ordering_id")
    private Ordering ordering;

    // 생성 메소드
    public static OrderingItem createOrderItem(Item item, int count) {
        OrderingItem orderItem = new OrderingItem();
        orderItem.setItem(item);
        orderItem.setQuantity(count);

        // 재고 감소
        item.removeStock(count);

        return orderItem;
    }

    public void cancel() {
        // 재고수량 복구
        getItem().addStockQuantity(this.quantity);
    }

}
