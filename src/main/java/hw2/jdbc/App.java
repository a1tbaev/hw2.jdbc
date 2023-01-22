package hw2.jdbc;

import hw2.jdbc.config.models.Employee;
import hw2.jdbc.config.models.Job;
import hw2.jdbc.config.service.EmployeeServiceImpl;
import hw2.jdbc.config.service.JobServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        JobServiceImpl jobService = new JobServiceImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Job job = new Job("Instructor", "JavaScript", "Fronted developer", 2);
        Employee employee = new Employee("Adil", "Aitbaev", 14, "adil@gmail", 2);

        while (true) {
            System.out.println("""
                    1 - create job
                    2 - add job
                    3 - get job by id
                    4 - sort by experience
                    5 - delete description
                    6 - get job by employee
                    7 - create employee
                    8 - add employee
                    9 - drop table employee
                    10 - clean table employee
                    11 - update employee
                    12 - get all employees
                    13 - find by email
                    14 - get employee by id
                    15 - get employee by position
                    """);
            switch (scanner.nextInt()) {
                case 1 -> System.out.println(jobService.createJobTable());
                case 2 -> System.out.println(jobService.addJob(job));
                case 3 -> System.out.println(jobService.getJobById(2L));
                case 4 -> System.out.println(jobService.sortByExperience("desc"));
                case 5 -> System.out.println(jobService.deleteDescriptionColumn());
                case 6 -> System.out.println(jobService.getJobByEmployeeId(2L));
                case 7 -> System.out.println(employeeService.createEmployee());
                case 8 -> System.out.println(employeeService.addEmployee(employee));
                case 9 -> System.out.println(employeeService.dropTable());
                case 10 -> System.out.println(employeeService.cleanTable());
                case 11 -> System.out.println(employeeService.updateEmployee(2L, employee));
                case 12 -> employeeService.getAllEmployees().forEach(System.out::println);
                case 13 -> System.out.println(employeeService.findByEmail("adil@gmail"));
                case 14 -> System.out.println(employeeService.getEmployeeById(2L));
                case 15 -> System.out.println(employeeService.getEmployeeByPosition("Mentor"));
            }
        }
    }
}
