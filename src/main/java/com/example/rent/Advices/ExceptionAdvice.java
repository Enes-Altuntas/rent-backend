package com.example.rent.Advices;

import com.example.rent.Exception.CustomInvalidFieldException;
import com.example.rent.Exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementException(NoSuchElementException noSuchElementException) {
        List<String> details = new ArrayList<>();
        details.add(noSuchElementException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Veri bulunamadı!", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> details = new ArrayList<>();
        methodArgumentNotValidException.getFieldErrors().forEach(fieldError -> {
            details.add(fieldError.getDefaultMessage());
        });
        ErrorResponse errorResponse = new ErrorResponse("Hatalı Alan!", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomInvalidFieldException.class)
    public ResponseEntity<?> customInvalidFieldException(CustomInvalidFieldException customInvalidFieldException) {
        List<String> details = new ArrayList<>();
        details.add(customInvalidFieldException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Hatalı Alan!", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
