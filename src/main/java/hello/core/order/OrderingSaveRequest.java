package hello.core.order;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderingSaveRequest {
    private Long memberId;
    private List<Long> itemId;
    private List<Integer> count;

}
