package hello.core.item;

import hello.core.common.BaseTimeEntity;
import hello.core.orderitem.OrderingItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor // 리플렉션 왜 protected 인지 정리하기
@Getter
@Builder // 빌더
@AllArgsConstructor // 빌더
@Entity // db
public class Item extends BaseTimeEntity {
    // -id, name, price(int), stockQuantity(int), imagePath(String), createdTime, updatedTime
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private Integer stockQuantity;
    private String imagePath;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderingItem> orderingItems;


    public void removeStock(int count) {
        this.stockQuantity  = this.getStockQuantity() - count;
    }

    public void addStock(int count) {
        this.stockQuantity  = this.getStockQuantity() + count;
    }

}
