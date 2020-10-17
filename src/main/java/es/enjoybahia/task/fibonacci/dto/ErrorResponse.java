package es.enjoybahia.task.fibonacci.dto;

public class ErrorResponse {
    private String errorCode;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String toString() {
        return "ErrorResponse{errorCode='" + this.errorCode + "', message='" + this.message + "'}";
    }
}