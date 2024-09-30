package ru.arkhipov.MySecondTestAppSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Codes;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnsupportedCodeException.class)
    public ResponseEntity<Response> handleUnsupportedCodeException(UnsupportedCodeException ex) {
        Response response = Response.builder()
                .code(Codes.FAILED)
                .errorcode("unsupportedCodeException")
                .errorMessage(ex.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleGeneralException(Exception ex) {
        Response response = Response.builder()
                .code(Codes.FAILED)
                .errorcode("UnknownException")
                .errorMessage("Произошла непредвиденная ошибка: " + ex.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
