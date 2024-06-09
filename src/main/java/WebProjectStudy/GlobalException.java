package WebProjectStudy;

import WebProjectStudy.exception.InvalidFormatException;
import WebProjectStudy.exception.InvalidLengthException;
import WebProjectStudy.exception.IsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // 에러 메시지를 저장할 Map 생성
        Map<String, String> errors = new HashMap<>();

        // 유효성 검사 실패한 모든 에러를 순회
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // 에러가 발생한 필드 이름 가져오기
            String fieldName = ((FieldError) error).getField();
            // 에러 메시지 가져오기
            String errorMessage = error.getDefaultMessage();
            // 에러 정보를 Map에 저장 (필드 이름 -> 에러 메시지)
            errors.put(fieldName, errorMessage);
        });

        // BAD_REQUEST (400) 상태 코드로 에러 메시지를 응답 본문에 담아 반환
        return ResponseEntity.badRequest().body(errors);
    }

    //공백확인
    @ExceptionHandler(IsNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(IsNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    //올바른 형식확인
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<String> InvalidFormatException(InvalidFormatException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //올바른 글자수 확인
    @ExceptionHandler(InvalidLengthException.class)
    public ResponseEntity<String> InvalidLengthException(InvalidLengthException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
