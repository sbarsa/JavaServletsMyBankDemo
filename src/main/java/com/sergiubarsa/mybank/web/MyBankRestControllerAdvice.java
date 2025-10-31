package com.sergiubarsa.mybank.web;

import com.sergiubarsa.mybank.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyBankRestControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorMessage("Validation failed");
        exception.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getField)
                .forEach(errorDto::addFailedField);
        return errorDto;
    }

}
