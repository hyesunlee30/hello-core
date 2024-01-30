package hello.core.member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MemberListLoadResponse {
     //id, name, email, password, address, role(enum - ADMIN, USER), createdTime, updatedTime, orderings(Ordering과 OneToMany관계)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String role;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public static MemberListLoadResponse of (Member member) {
        return MemberListLoadResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .address(member.getAddress())
                .role(member.getGrade().name())
                .createdTime(member.getCreatedTime())
                .updatedTime(member.getUpdatedTime())
                .build();
    }
}
