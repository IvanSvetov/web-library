package skypro.java.course4.weblibrary.service;

import skypro.java.course4.weblibrary.model.Employee;
import skypro.java.course4.weblibrary.repository.EmployeeRepository;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee getEmployeeByID(Long id);
    Employee add(Employee employee);
    void remove(Long id);
    Employee find(Long id);
    Employee edit(Employee employee);
    Collection<Employee> findAll();


//    List<Employee> getAllEmployees();
//    String salarySum(List<Employee> employeeList);
//
//    String salaryMin(List<Employee> employeeList);
//
//    String salaryMax(List<Employee> employeeList);
//
//    String getAvg(List<Employee> employeeList);
//
//    String getMoreThanAvg(List<Employee> employeeList);


}
