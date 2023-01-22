package hw2.jdbc.config.service;

import hw2.jdbc.config.doa.EmployeeDaoImpl;
import hw2.jdbc.config.models.Employee;
import hw2.jdbc.config.models.Job;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
    @Override
    public String createEmployee() {
        employeeDao.createEmployee();
        return "successfully created!!!";
    }

    @Override
    public String addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
        return "successfully added!!!";
    }

    @Override
    public String dropTable() {
        employeeDao.dropTable();
        return "the deletion was successful!!";
    }

    @Override
    public String cleanTable() {
        employeeDao.cleanTable();
        return "cleaning was successful!!";
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        employeeDao.updateEmployee(id, employee);
        return "successfully updated!!";
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeDao.findByEmail(email);
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        return employeeDao.getEmployeeByPosition(position);
    }
}
