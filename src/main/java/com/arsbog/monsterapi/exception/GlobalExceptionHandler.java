package com.arsbog.monsterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.arsbog.monsterapi.dto.ErrorResponse;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MonsterNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMonsterNotFound (MonsterNotFoundException exception){
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
