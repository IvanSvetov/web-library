package skypro.java.course4.weblibrary.controller;
import org.springframework.web.bind.annotation.*;
import skypro.java.course4.weblibrary.model.Employee;
import skypro.java.course4.weblibrary.service.EmployeeService;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
        @GetMapping("/all")
    public Collection<Employee> getAll() {
        return employeeService.findAll();
    }

        @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }
    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        employeeService.deleteById(id);
    }
    @GetMapping("value = /employees/{id}")
    public Optional<Employee> findById(@PathVariable (name = "id") Integer id) {
        return employeeService.findById(id);
    }

    @GetMapping()
    public List<Employee> getEmployeesByParams(@RequestParam Map<String, String> params) {
        String salary = params.get("salary");
        String name = params.get("name");

        if (isNull(salary)){
            return employeeService.getAllEmployeesByName(name);
        }else {
            int salaryInt = Integer.parseInt(salary);
            return employeeService.getAllEmployeesByNameAndSalary(name, salaryInt);
        }

    }






//    @GetMapping
//    public Collection<Employee> getAll() {
//        return employeeService.findAll();
//    }

//    @PostMapping
//    public void addEmployee(@RequestBody Employee employee) {
//        employeeService.add(employee);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee, @PathVariable Long id) {
//        Employee foundStudent = employeeService.editEmployee(employee, id);
//        return ResponseEntity.ok(foundStudent);
//    }
//
//    @GetMapping("/{id}")
//    public Employee getByID(@PathVariable Long id) {
//        return employeeService.getEmployeeByID(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteEmployee(@PathVariable Long id) {
//        employeeService.remove(id);
//    }
//
//    @GetMapping("/salaryHigherThan")
//    public Collection<Employee> getEmployeesWithSalaryHigherThan(@RequestParam("salary") Integer compareSalary) {
//        return employeeService.salaryHighterThan(compareSalary);
//    }
}

