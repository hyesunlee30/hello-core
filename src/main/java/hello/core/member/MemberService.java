package hello.core.member;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void save(MemberSaveRequest request) {
        repository.save(MemberSaveRequest.toEntity(request));
    }

    public List<MemberListLoadResponse> loadMemberList() {
        List<Member> members = repository.findAll();

        return members.stream().map(MemberListLoadResponse::of).collect(Collectors.toList());
    }

    public MemberOrderListLoadResponse loadMemberOrderList(Long id) {
        Optional<Member> member = repository.findById(id);
        MemberOrderListLoadResponse response = null;
        if(member.isPresent()) {
            return MemberOrderListLoadResponse.of(member.get());
        }

        return response;
    }


//    void join(Member member);
//
//    Member findMember(Long memberId);
}
