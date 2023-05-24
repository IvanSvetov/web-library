package skypro.java.course4.weblibrary.repository;

import skypro.java.course4.weblibrary.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeByID();

}
