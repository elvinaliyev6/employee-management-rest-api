package az.spring.employeemanagementrestapi.rest.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private int age;

    private double salary;

}
