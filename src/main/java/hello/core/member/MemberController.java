package hello.core.member;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/member/{id}/orders")
    public MemberOrderListLoadResponse loadMemberOrder(@PathVariable Long id) {
        return memberService.loadMemberOrderList(id);
    }


}
