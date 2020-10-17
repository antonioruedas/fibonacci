package es.enjoybahia.task.fibonacci.exception;

public class BadRequestException extends Exception {
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    private String resultCode = "BadRequestException";

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, String resultCode) {
        super(message);
        this.resultCode = resultCode;
    }
}