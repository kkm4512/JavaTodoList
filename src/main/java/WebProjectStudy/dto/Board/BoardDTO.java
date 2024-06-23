package WebProjectStudy.dto.Board;

import WebProjectStudy.dto.customeValidate.ListElementPattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardDTO {
    @NotBlank(message = "[DTO] 제목은 공백 일 수 없습니다.")
    @Size(min = 1, max=20, message = "[DTO] 글자수는 최소 1자이상, 최대20자이하 입니다")
    @Pattern(regexp = "[a-zA-Z가-힣]+",message = "[DTO] 제목은 영어(소문자),영어(대문자), 한글만 가능합니다")
    private String title;

    @Size(min = 1, max=50, message = "[DTO] 글자수는 최소 1자이상, 최대50자이하 입니다")
    @ListElementPattern(regexp = "^[a-zA-Z가-힣]+$", message = "[DTO] 본문은 영어(소문자), 영어(대문자), 한글만 가능합니다")
    private List<String> descriptions;
}
