package hello.core.member;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberSaveRequest {
    private String name;
    private String email;
    private String password;
    private String address;

    public static Member toEntity(MemberSaveRequest request) {

        Member member = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .address(request.getAddress())
                .grade(Grade.USER)
                .build();

        return member;
    }
}
