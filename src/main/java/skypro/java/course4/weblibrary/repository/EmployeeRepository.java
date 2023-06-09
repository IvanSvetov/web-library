package skypro.java.course4.weblibrary.repository;

import org.springframework.data.repository.CrudRepository;
import skypro.java.course4.weblibrary.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameAndSalary(String name, int salary);


//    public List<Employee> getAllEmployees();
//
//    public Employee getEmployeeByID(Long id);
//
//    Employee addEmployee(Employee employee);
//    void removeEmployee(Long id);
//    Employee editEmployee(Long id, Employee employee);
}
