package hello.core.member;

import hello.core.common.BaseTimeEntity;
import hello.core.order.Ordering;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor // 리플렉션 왜 protected 인지 정리하기
@Getter
@Builder // 빌더
@AllArgsConstructor // 빌더
@Entity // db
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 20, unique = true, nullable = false)
    private String email;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Ordering> orderings;


}
