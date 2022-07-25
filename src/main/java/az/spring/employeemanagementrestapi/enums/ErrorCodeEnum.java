package az.spring.employeemanagementrestapi.enums;

public enum ErrorCodeEnum {

    EMPLOYEE_NOT_FOUND("Can not find employee given id");

    private final String message;

    ErrorCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
