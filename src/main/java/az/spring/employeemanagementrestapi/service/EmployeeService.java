package az.spring.employeemanagementrestapi.service;

import az.spring.employeemanagementrestapi.rest.model.dto.EmployeeDto;
import az.spring.employeemanagementrestapi.rest.model.response.EmployeeResponse;
import org.springframework.stereotype.Service;

public interface EmployeeService {

    EmployeeResponse getAllEmployees();

    EmployeeDto getEmployee(long id);

    EmployeeResponse getEmployeeByNameAndSurname(String name,String surname);


}
