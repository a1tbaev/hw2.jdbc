package hw2.jdbc.config.doa;

import hw2.jdbc.config.Util;
import hw2.jdbc.config.models.Employee;
import hw2.jdbc.config.models.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao{
    private Connection connection;

    public EmployeeDaoImpl() {
        this.connection = Util.getConnection();
    }

    public void createEmployee() {
        String query = """
                create table if not exists  employees (id serial primary key ,
                first_name varchar,
                last_name varchar,
                age integer,
                email varchar,
                job_id integer references job(id));
                """;

        try (Statement statement = connection.createStatement()){
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addEmployee(Employee employee) {
        String query = """
                insert into employees (first_name, last_name, age, email, job_id)
                values(?, ?, ?, ?, ?);
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setLong(5, employee.getJobId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropTable() {
        String query = """
                drop table if exists employees;
                """;
        try (Statement statement = connection.createStatement()){
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanTable() {
        String query = "truncate table employees cascade";

        try (Statement statement = connection.createStatement()){
           statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmployee(Long id, Employee employee) {
        String query = """
                update employees set first_name = ?, last_name = ?, age = ?, email = ?, job_id = ?
                where id = ?;
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setLong(5, employee.getJobId());
            preparedStatement.setLong(6, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        String query = """
                select * from employees;
                """;

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setAge(resultSet.getInt(4));
                employee.setEmail(resultSet.getString(5));
                employee.setJobId(resultSet.getInt(6));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public Employee findByEmail(String email) {
        Employee employee = new Employee();

        String query = """
                select * from employees where email = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setAge(resultSet.getInt(4));
                employee.setEmail(resultSet.getString(5));
                employee.setJobId(resultSet.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employee;
    }

    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        Map<Employee, Job> employeeJobMap = new HashMap<>();

        String query = """
                select * from employees full join job j on employees.job_id = j.id where employees.id = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Employee employee = new Employee();
                Job job = new Job();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setAge(resultSet.getInt(4));
                employee.setEmail(resultSet.getString(5));
                employee.setJobId(resultSet.getInt(6));
                job.setId(resultSet.getLong(7));
                job.setPosition(resultSet.getString(8));
                job.setProfession(resultSet.getString(9));
                //job.setDescription(resultSet.getString(10));
                job.setExperience(resultSet.getInt(10));
                employeeJobMap.put(employee, job);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeJobMap;
    }

    public List<Employee> getEmployeeByPosition(String position) {
        List<Employee> employees = new ArrayList<>();
        String query = """
                select * from employees join job j on employees.job_id = j.id where j.position = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, position);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setAge(resultSet.getInt(4));
                employee.setEmail(resultSet.getString(5));
                employee.setJobId(resultSet.getInt(6));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
