package az.spring.employeemanagementrestapi.controller;

import az.spring.employeemanagementrestapi.enums.ErrorCodeEnum;
import az.spring.employeemanagementrestapi.exception.CustomNotFoundException;
import az.spring.employeemanagementrestapi.rest.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handCustomRestException(CustomNotFoundException e) {
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getCode())
                .message(ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInputParam(MethodArgumentTypeMismatchException e) {
        String paramName = e.getParameter().getParameterName();
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .message(paramName + ErrorCodeEnum.VALIDATION_ERROR.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidiation(MethodArgumentNotValidException e) {
        StringBuilder paramNames = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> paramNames.append(fieldError.getField()));
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .message(paramNames + ErrorCodeEnum.VALIDATION_ERROR.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnknownException(Exception e) {
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.UNKNOWN_ERROR.getCode())
                .message(ErrorCodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

}
