package skypro.java.course4.weblibrary.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skypro.java.course4.weblibrary.model.Employee;
import skypro.java.course4.weblibrary.repository.EmployeeRepository;
import skypro.java.course4.weblibrary.repository.EmployeeRepositoryImpl;
import skypro.java.course4.weblibrary.service.EmployeeService;
import skypro.java.course4.weblibrary.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    ResponseEntity<Employee> ResponseEntity;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public void addEmployee(@RequestBody Employee employee) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        Employee foundStudent = employeeService.edit(employee);
        return ResponseEntity;
    }

    @GetMapping("/{id}")
    public Employee getByID(@PathVariable Long id) {
        return employeeService.find(id);
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable Long id) {
        employeeService.remove(id);
        return null;
    }

    @GetMapping("/salaryHigherThan")
    public List<Employee> getEmployeesWithSalaryHigherThan(@RequestParam("salary") Integer compareSalary) {
        return null;
    }


















 /*   @GetMapping
    public List<Employee> showCounter() {
        return employeeService.getAllEmployees();
    }*/
/*    @GetMapping("/salary/sum")
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
    }*/
}

//    localhost:8080/sayHello
//    localhost:8080/employee/salary/sum
//    localhost:8080/employee/salary/min
//    localhost:8080/employee/salary/max
//    localhost:8080/employee/avg-salary
//    localhost:8080/employee/high-salary
