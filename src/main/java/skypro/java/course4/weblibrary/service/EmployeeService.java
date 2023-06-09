package skypro.java.course4.weblibrary.service;

import skypro.java.course4.weblibrary.model.Employee;

import java.util.List;

public interface EmployeeService {


    List<Employee> getAllEmployees();
    String salarySum(List<Employee> employeeList);

    String salaryMin(List<Employee> employeeList);

    String salaryMax(List<Employee> employeeList);

    String getAvg(List<Employee> employeeList);

    String getMoreThanAvg(List<Employee> employeeList);
}
