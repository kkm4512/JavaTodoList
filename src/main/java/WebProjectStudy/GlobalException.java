package WebProjectStudy;

import WebProjectStudy.exception.*;
import WebProjectStudy.typeClass.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // 에러 메시지를 저장할 Map 생성
        Map<String,String> errors = new HashMap<>();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            //error 발생된 이름
            String fieldName = ((FieldError) error).getField();
            //error 발생한 이름의 메시지내용
            String errorMessage = error.getDefaultMessage();

            //에러메시지에 공백이 포함되어있으면 status 바꾸기
            if (errorMessage.contains("공백")){
                status = HttpStatus.NOT_FOUND;
            }
            //errors 객체에 추가
            errors.put(fieldName,errorMessage);
        }

        //ErrorResponse 타입 지정해주고 return
        ErrorResponse responseBody = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errors);
        return ResponseEntity.status(status).body(responseBody);
    }

    //공백확인
    @ExceptionHandler(HandleIsNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(HandleIsNotFoundException e){
        return createErrorResponse(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    //올바른 형식확인
    @ExceptionHandler(HandleInvalidFormatException.class)
    public ResponseEntity<ErrorResponse> InvalidFormatException(HandleInvalidFormatException e){
        return createErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    //올바른 글자수 확인
    @ExceptionHandler(HandleInvalidLengthException.class)
    public ResponseEntity<ErrorResponse> InvalidLengthException(HandleInvalidLengthException e){
        return createErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    //회원 중복 오류
    @ExceptionHandler(HandleMemberDuplicateException.class)
    public ResponseEntity<ErrorResponse> handleMemberDuplicateException(HandleMemberDuplicateException e) {
        return createErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    //회원 존재 확인 (ID)
    @ExceptionHandler(HandleCheckIdMember.class)
    public ResponseEntity<ErrorResponse> handleMemberDuplicateException(HandleCheckIdMember e) {
        return createErrorResponse(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    //에러 동일한 형식으로 프론트 던져주기
    public ResponseEntity<ErrorResponse> createErrorResponse(String msg,HttpStatus status){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", msg);
        ErrorResponse responseBody = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errors);
        return ResponseEntity.status(status).body(responseBody);
    }

}
