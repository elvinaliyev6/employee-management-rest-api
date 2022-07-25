package az.spring.employeemanagementrestapi.repository;

import az.spring.employeemanagementrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findEmployeeByNameAndSurname(String name,String surname);

}
