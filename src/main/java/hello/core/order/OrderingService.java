package hello.core.order;

import hello.core.item.Item;
import hello.core.item.ItemRepository;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.orderitem.OrderingItem;
import hello.core.orderitem.OrderingItemRepository;
import javafx.util.Builder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderingService {
    //Order createOrder(Long memberId, String itemName, int itemPrice);
    private final OrderingRepository repository;
    private final OrderingItemRepository orderingItemRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    public OrderingService(OrderingRepository repository, OrderingItemRepository orderingItemRepository, MemberRepository memberRepository, ItemRepository itemRepository) {
        this.repository = repository;
        this.orderingItemRepository = orderingItemRepository;
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
    }

    public List<OrderingListLoadResponse> loadOrderList() {
        List<Ordering> orderings = repository.findAll();
        return orderings.stream().map(OrderingListLoadResponse::of).collect(Collectors.toList());
    }

    public void save(OrderingSaveRequest request) {
        //    private Long memberId;
        //    private List<Long> itemId;
        //    private List<Long> count;
        //List<OrderingItem> orderingItems =

        //누가 주문했는지
        Member member = memberRepository.findById(request.getMemberId()).get();
        //어떤 item을 주문했는지
        List<Item> items = itemRepository.findAllById(request.getItemId());

        // 주문상품 생성
        List<OrderingItem> orderingItems = new ArrayList<>();
        List<Integer> countList = request.getCount();
        for(int i = 0; i<items.size(); i++) {
            OrderingItem orderItem = OrderingItem.createOrderItem(items.get(i), countList.get(i));
            orderingItems.add(orderItem);

        }


        // 주문 생성
        Ordering ordering = Ordering.createOrdering(member, orderingItems);

        // 주문 저장 ( OrderItem이 cascade 설정이 되어있기 때문에 주문만 저장해도 다 저장된다.)
        repository.save(ordering);






        //repository.save();
    }
}
