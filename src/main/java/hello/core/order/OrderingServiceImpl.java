package hello.core.order;



//public class OrderingServiceImpl implements OrderingService {
//
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//
//    @Override
//    public Order createOrder(Long memberId, String itemName, int itemPrice) {
//        Member member = memberRepository.findById(memberId);
//        int discountPrice = discountPolicy.discount(member,itemPrice);
//
//        return new Order(memberId, itemName, itemPrice, discountPrice);
//    }
//}
