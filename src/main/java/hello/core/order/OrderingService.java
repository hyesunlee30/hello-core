package hello.core.order;

import hello.core.item.Item;
import hello.core.item.ItemRepository;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.orderitem.OrderingItem;
import hello.core.orderitem.OrderingItemRepository;
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
        Member member = memberRepository.findById(request.getMemberId()).get();
        List<Item> items = itemRepository.findAllById(request.getItemId());
        List<OrderingItem> orderingItems = new ArrayList<>();
        List<Integer> countList = request.getCount();
        for(int i = 0; i<items.size(); i++) {
            OrderingItem orderItem = OrderingItem.createOrderItem(items.get(i), countList.get(i));
            orderingItems.add(orderItem);
        }
        Ordering ordering = Ordering.createOrdering(member, orderingItems);
        repository.save(ordering);
    }

    public void cancel(Long id) {

        Ordering ordering = repository.findById(id).get();
        ordering.cancel();


    }
}
