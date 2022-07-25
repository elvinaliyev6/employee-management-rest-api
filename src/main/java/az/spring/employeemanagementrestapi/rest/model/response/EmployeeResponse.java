package az.spring.employeemanagementrestapi.rest.model.response;

import az.spring.employeemanagementrestapi.rest.model.dto.EmployeeDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private List<EmployeeDto> employees;

}
