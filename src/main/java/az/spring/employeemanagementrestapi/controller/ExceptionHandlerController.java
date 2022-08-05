package az.spring.employeemanagementrestapi.controller;

import az.spring.employeemanagementrestapi.enums.ErrorCodeEnum;
import az.spring.employeemanagementrestapi.exception.CustomNotFoundException;
import az.spring.employeemanagementrestapi.rest.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

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

        List<String> fieldErrorNamesList=e.getBindingResult().getFieldErrors().stream().map(fieldError ->fieldError.getField())
                .collect(Collectors.toList());

        return ErrorResponse.builder()
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .message(fieldErrorNamesList + ErrorCodeEnum.VALIDATION_ERROR.getMessage())
                .build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleAccessDeniedException(AccessDeniedException e){
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.ACCESS_DENIED.getCode())
                .message(ErrorCodeEnum.ACCESS_DENIED.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnknownException(Exception e) {
        e.printStackTrace();
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.UNKNOWN_ERROR.getCode())
                .message(ErrorCodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

}
