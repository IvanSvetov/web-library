package skypro.java.course4.weblibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import skypro.java.course4.weblibrary.controller.dto.ReportDTO;
import skypro.java.course4.weblibrary.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameAndSalary(String name, int salary);
    @Query("SELECT e FROM Employee e where e.salary = (SELECT max(salary) FROM Employee)")
    List<Employee> findEmployeeWithBiggestSalary();
    List<Employee> findAllByPositionId(int positionId);
    @Query("SELECT new skypro.java.course4.weblibrary.controller.dto.ReportDTO(e.position.name, count(e.id), max(e.salary), min(e.salary), avg(e.salary) ) FROM Employee e GROUP BY e.position.name")
    List<ReportDTO> buildReports();


//    public List<Employee> getAllEmployees();
//
//    public Employee getEmployeeByID(Long id);
//
//    Employee addEmployee(Employee employee);
//    void removeEmployee(Long id);
//    Employee editEmployee(Long id, Employee employee);
}
