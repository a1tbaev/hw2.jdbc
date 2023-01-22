package hw2.jdbc.config.service;
import hw2.jdbc.config.models.Employee;
import hw2.jdbc.config.models.Job;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    String createEmployee();
    String addEmployee(Employee employee);
    String dropTable();
    String cleanTable();
    String updateEmployee(Long id,Employee employee);
    List<Employee> getAllEmployees();
    Employee findByEmail(String email);
    Map<Employee, Job> getEmployeeById(Long employeeId);
    List<Employee> getEmployeeByPosition(String position);
}
