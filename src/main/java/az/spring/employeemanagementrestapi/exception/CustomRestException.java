package az.spring.employeemanagementrestapi.exception;

import az.spring.employeemanagementrestapi.enums.ErrorCodeEnum;

public class CustomRestException extends RuntimeException{

    public CustomRestException(String message) {
        super(message);
    }

    public CustomRestException(ErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getMessage());
    }
}
