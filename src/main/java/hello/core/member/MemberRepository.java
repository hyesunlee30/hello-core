package hello.core.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
//    void save(Member meber);
//
//    Member findById(Long memberId);
}
