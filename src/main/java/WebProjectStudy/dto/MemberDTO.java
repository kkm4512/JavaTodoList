package WebProjectStudy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private Long id;

    @NotBlank(message = "이름은 공백 일 수 없습니다")
    @Size(max = 10, min = 5, message = "이름은 최소 5글자, 최대 10글자 입니다")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "이름은 숫자와, 영문자로만 구성 가능합니다")
    private String name;

    @NotBlank(message = "비밀번호는 공백 일 수 없습니다.")
    @Size(max = 20, min = 5,message = "비밀번호는 최소 5글자, 최대 20글자 입니다")
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+=]+$",message = "비밀번호는 숫자와, 영문자,특수문자로만 구성 가능합니다")
    private String password;

    @NotBlank(message = "닉네임은 공백 일 수 없습니다")
    @Size(max = 10, min = 5, message = "이름은 최소 5글자, 최대 10글자 입니다")
    @Pattern(regexp = "^[가-힣]+$",message = "이름은 한국어로만 구성 가능합니다")
    private String nickname;
}
