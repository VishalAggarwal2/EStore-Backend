package com.onlineStore.EStore.Excptions;

import com.onlineStore.EStore.DTO.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeller {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        ApiResponseMessage message = ApiResponseMessage.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .Success(true)
                .build();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomExpectation.class)
    public ResponseEntity<ApiResponseMessage> customExpectationHandler(CustomExpectation ex) {
        ApiResponseMessage message = ApiResponseMessage.builder()
                .message(ex.getMessage())
                .status(HttpStatus.OK)
                .Success(true)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
