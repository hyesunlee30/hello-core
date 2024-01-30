package hello.core.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member/new")
    public void memberNew(@RequestBody MemberSaveRequest request) {
        memberService.save(request);
    }

    @GetMapping("/members")
    public List<MemberListLoadResponse> loadMembers() {
        return memberService.loadMemberList();
    }
    // -회원별주문목록조회(/member/{id}/orders)

    @GetMapping("/member/{id}/orders")
    public List<MemberOrderListLoadResponse> loadMemberOrder() {
        return memberService.loadMemberOrderList();
    }


}
