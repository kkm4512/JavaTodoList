package WebProjectStudy.exception;

public class MemberDuplicateException extends RuntimeException{
    public MemberDuplicateException(String msg){
        super(msg);
    }
}
