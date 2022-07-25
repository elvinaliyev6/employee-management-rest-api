package az.spring.employeemanagementrestapi.rest.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private long id;

    private String name;

    private String surname;

    private int age;

    private double salary;

}
