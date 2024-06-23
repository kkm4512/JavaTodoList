package WebProjectStudy.dto.customeValidate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.regex.Pattern;

public class ListElementPatternValidator implements ConstraintValidator<ListElementPattern, List<String>> {

    private Pattern pattern;

    @Override
    public void initialize(ListElementPattern constraintAnnotation) {
        this.pattern = Pattern.compile(constraintAnnotation.regexp());
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // null 값은 유효성 검사를 통과함
        }
        for (String element : value) {
            if (element == null || !pattern.matcher(element).matches()) {
                return false;
            }
        }
        return true;
    }
}

