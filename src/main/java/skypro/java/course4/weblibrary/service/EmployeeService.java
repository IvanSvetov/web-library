package skypro.java.course4.weblibrary.service;

import skypro.java.course4.weblibrary.controller.dto.EmployeeDTO;
import skypro.java.course4.weblibrary.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDTO> findAll();
    void addEmployee(Employee employee);
    void deleteById(Integer id);
    Optional<Employee> findById(Integer id);
    List<Employee> getAllEmployeesByName(String name);
    List<Employee> getAllEmployeesByNameAndSalary(String name, int salary);
    List<EmployeeDTO> getEmployeeWithHighestSalary();
    List<EmployeeDTO> getEmployeeByPosition(int positionId);
    List<EmployeeDTO> getEmployeeByPage(int page);




//
//    Employee getEmployeeByID(Long id);
//    Employee add(Employee employee);
//    void remove(Long id);
//
//    Employee editEmployee(Employee employee, Long id);
//
//    Collection<Employee> salaryHighterThan(Integer compareSalary);



}
