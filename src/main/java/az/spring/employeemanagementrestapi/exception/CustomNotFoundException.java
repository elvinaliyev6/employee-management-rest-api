package az.spring.employeemanagementrestapi.exception;

import az.spring.employeemanagementrestapi.enums.ErrorCodeEnum;

public class CustomNotFoundException extends RuntimeException{

    public CustomNotFoundException(String message) {
        super(message);
    }

    public CustomNotFoundException(ErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getMessage());
    }
}
