package skypro.java.course4.weblibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import skypro.java.course4.weblibrary.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameAndSalary(String name, int salary);
    @Query("SELECT e FROM Employee e where e.salary = (SELECT max(salary) FROM Employee)")
    List<Employee> findEmployeeWithBiggestSalary();
    List<Employee> findAllByPositionId(int positionId);


//    public List<Employee> getAllEmployees();
//
//    public Employee getEmployeeByID(Long id);
//
//    Employee addEmployee(Employee employee);
//    void removeEmployee(Long id);
//    Employee editEmployee(Long id, Employee employee);
}
