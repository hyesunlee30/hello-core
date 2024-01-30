package hello.core.order;

import hello.core.common.BaseTimeEntity;
import hello.core.member.Member;
import hello.core.orderitem.OrderingItem;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor // 리플렉션 왜 protected 인지 정리하기
@Getter
@Setter
@Builder // 빌더
@AllArgsConstructor // 빌더
@Entity // db
@Table(name = "ordering")
public class Ordering extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "ordering", cascade = CascadeType.ALL)
    @Builder.Default
    private List<OrderingItem> orderingItems = new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;
        member.getOrderings().add(this);
    }

    public void addOrderItem(OrderingItem orderingItem) {
        orderingItems.add(orderingItem);
        orderingItem.setOrdering(this);
    }


    // 생성 메소드
    public static Ordering createOrdering(Member member,List<OrderingItem> orderingItems) {
        Ordering order = new Ordering();
        order.setMember(member);
        for(OrderingItem orderItem : orderingItems) {
            order.addOrderItem(orderItem);
        }
        order.setOrderStatus(OrderStatus.ORDERED);
        return order;
    }
    public void cancel() {

        this.orderStatus = OrderStatus.CANCELED ;
        for(OrderingItem orderItem : this.orderingItems) {
            orderItem.cancel();
        }
    }


}
