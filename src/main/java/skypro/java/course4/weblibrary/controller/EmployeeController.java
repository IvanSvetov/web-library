package skypro.java.course4.weblibrary.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import skypro.java.course4.weblibrary.controller.dto.EmployeeDTO;
import skypro.java.course4.weblibrary.controller.dto.EmployeeToDTO;
import skypro.java.course4.weblibrary.exceptions.EmployeeNotFoudExeption;
import skypro.java.course4.weblibrary.model.Employee;
import skypro.java.course4.weblibrary.service.EmployeeService;

import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
        @GetMapping("/all")
    public List<EmployeeDTO> getAll() {
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
    public EmployeeDTO findById(@PathVariable (name = "id") Integer id) {
        return EmployeeToDTO.fromEmployee(employeeService.findById(id).orElseThrow(EmployeeNotFoudExeption::new));
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
    @GetMapping("/withHighestSalary")
    public List<EmployeeDTO> getEmployeeWithHighSalary() {
        return employeeService.getEmployeeWithHighestSalary();

    }

    @GetMapping("/byPosition")
    public List<EmployeeDTO> getEmployeesByPosition(@RequestParam(name = "position", required = false) Integer positionId) {
        if (isNull(positionId)) {
            return employeeService.findAll();
        } else {
            return employeeService.getEmployeeByPosition(positionId);
        }
    }

    @GetMapping("/page")
    public List<EmployeeDTO> getEmployeeByPage(@RequestParam(name = "page") int page) {
        return employeeService.getEmployeeByPage(page);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestPart("employees") MultipartFile employees){
        employeeService.upload(employees);
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

