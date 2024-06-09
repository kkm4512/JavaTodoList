package WebProjectStudy.typeClass;

import java.util.Map;

public class ErrorResponse {
    private int status;
    private Map<String,String> errors;

    public ErrorResponse(int status, Map<String, String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
