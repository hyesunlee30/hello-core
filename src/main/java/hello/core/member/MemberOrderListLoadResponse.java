package hello.core.member;

import hello.core.order.Ordering;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MemberOrderListLoadResponse {
    private Long id;
    private List<Ordering> orderingList;

    public static MemberOrderListLoadResponse of(Member member) {
        return MemberOrderListLoadResponse.builder()
                .id(member.getId())
                .orderingList(member.getOrderings())
                .build();
    }
}
