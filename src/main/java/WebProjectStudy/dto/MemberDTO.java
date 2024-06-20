package WebProjectStudy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO extends BaseMemberDTO{

    @NotBlank(message = "[DTO] 닉네임은 공백 일 수 없습니다")
    @Size(max = 10, min = 5, message = "[DTO] 닉네임은 최소 5글자, 최대 10글자 입니다")
    @Pattern(regexp = "^[가-힣]+$",message = "[DTO] 닉네임은 한국어로만 구성 가능합니다")
    private String nickname;

    @Override
    public String toString() {
        return super.toString() +
                "nickname='" + nickname + '\'';
    }
}
