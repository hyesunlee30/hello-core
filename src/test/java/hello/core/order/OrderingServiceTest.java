package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.MemberRepository;
import hello.core.member.MemberSaveRequest;
import hello.core.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderingServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    void memberSave() {

        MemberSaveRequest request = MemberSaveRequest.builder()
                .name("test")
                .role(Grade.USER.name())
                .email("naver")
                .address("test")
                .build();

    }

}
