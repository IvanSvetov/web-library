package skypro.java.course4.weblibrary.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skypro.java.course4.weblibrary.model.Employee;
import skypro.java.course4.weblibrary.repository.EmployeeRepository;
import skypro.java.course4.weblibrary.repository.EmployeeRepositoryImpl;
import skypro.java.course4.weblibrary.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> showCounter() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/salary/sum")
    public String showSalarySum() {
        return employeeService.salarySum(employeeService.getAllEmployees());
    }


    @GetMapping("/salary/min")
    public String showSalaryMin() {
        return employeeService.salaryMin(employeeService.getAllEmployees());
    }

    @GetMapping("/salary/max")
    public String showSalaryMax() {
        return employeeService.salaryMax(employeeService.getAllEmployees());
    }
    @GetMapping("/avg-salary")
    public String showAvg() {
        return employeeService.getAvg(employeeService.getAllEmployees());
    }
    @GetMapping("/high-salary")
    public String showMoreThanAvg() {
        return employeeService.getMoreThanAvg(employeeService.getAllEmployees());
    }
}

//    localhost:8080/sayHello
//    localhost:8080/employee/salary/sum
//    localhost:8080/employee/salary/min
//    localhost:8080/employee/salary/max
//    localhost:8080/employee/avg-salary
//    localhost:8080/employee/high-salary
