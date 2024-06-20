package WebProjectStudy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseMemberDTO {
    private Long id;


    @NotBlank(message = "[DTO] 이름은 공백 일 수 없습니다")
    @Size(max = 10, min = 5, message = "[DTO] 이름은 최소 5글자, 최대 10글자 입니다")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "[DTO] 이름은 숫자와, 영문자로만 구성 가능합니다")
    private String name;

    @NotBlank(message = "[DTO] 비밀번호는 공백 일 수 없습니다.")
    @Size(max = 20, min = 5,message = "[DTO] 비밀번호는 최소 5글자, 최대 20글자 입니다")
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+=]+$",message = "[DTO] 비밀번호는 숫자와, 영문자,특수문자로만 구성 가능합니다")
    private String password;


    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'';
    }
}
