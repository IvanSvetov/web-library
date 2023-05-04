package skypro.java.course4.weblibrary.repository;

import org.springframework.stereotype.Repository;
import skypro.java.course4.weblibrary.model.Employee;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 48000),
            new Employee("Дима", 43000),
            new Employee("Олег", 45000),
            new Employee("Вика", 35000));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
