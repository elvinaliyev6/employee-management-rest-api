package az.spring.employeemanagementrestapi.repository;

import az.spring.employeemanagementrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
