package skypro.java.course4.weblibrary.service;

import skypro.java.course4.weblibrary.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee getEmployeeByID(Long id);
    Employee add(Employee employee);
    void remove(Long id);

    Employee editEmployee(Employee employee, Long id);
    Collection<Employee> findAll();
    Collection<Employee> salaryHighterThan(Integer compareSalary);



}
