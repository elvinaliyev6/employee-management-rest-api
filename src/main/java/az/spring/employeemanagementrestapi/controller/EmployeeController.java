package az.spring.employeemanagementrestapi.controller;

import az.spring.employeemanagementrestapi.rest.model.dto.EmployeeDto;
import az.spring.employeemanagementrestapi.rest.model.response.EmployeeResponse;
import az.spring.employeemanagementrestapi.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Tag(name = "Employee services",description = "employee services")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public EmployeeResponse getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    @Operation(summary = "This get employee by id")
    public EmployeeDto getEmployee(@PathVariable("id") long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping("/search")
    @Operation(summary = "This get employee by name and surname")
    public EmployeeResponse getEmployeeByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.getEmployeeByNameAndSurname(name, surname);
    }

    @PostMapping
    @Operation(summary = "This insert new employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid EmployeeDto employeeDto) {
        employeeService.insert(employeeDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "This updates employee")
    public void updateAll(@RequestBody EmployeeDto employeeDto, @PathVariable("id") long id) {
        employeeService.update(employeeDto, id);
    }

    @Operation(summary = "This updates employee")
    @PatchMapping("/{id}")
    public void updateSum(@RequestBody EmployeeDto employeeDto, @PathVariable("id") long id) {
        employeeService.updateSome(employeeDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "This delete employee")
    public void delete(@PathVariable("id") long id) {
        employeeService.delete(id);
    }

}
