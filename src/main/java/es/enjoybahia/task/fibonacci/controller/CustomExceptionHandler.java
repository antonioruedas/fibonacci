package es.enjoybahia.task.fibonacci.controller;

import es.enjoybahia.task.fibonacci.dto.ErrorResponse;
import es.enjoybahia.task.fibonacci.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleException(BadRequestException ex) {
        return new ErrorResponse("BadRequest", ex.getMessage());
    }
}
