package az.spring.employeemanagementrestapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Employee Service API",
                description = "Employee crud services",
                version = "v1"
        )
)
@EnableMethodSecurity
public class EmployeeManagementRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementRestApiApplication.class, args);
    }

}
