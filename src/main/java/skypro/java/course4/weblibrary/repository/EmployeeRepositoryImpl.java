package skypro.java.course4.weblibrary.repository;

import org.springframework.stereotype.Repository;
import skypro.java.course4.weblibrary.model.Employee;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final List<Employee> employeeList = List.of(
            new Employee(1,"Катя", "Ivanova", 48000, 1),
            new Employee(2,"Дима", "Petrova", 56000, 1),
            new Employee(3,"Олег", "Deeva", 37000, 2),
            new Employee(4,"Вика", "Zolova",35000, 3));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeByID(int id) {
        for (int i =0; i < employeeList.size(); i++) {
            if (employeeList.contains(id)) {
                return getEmployeeByID(id);
            }
        }
        return employeeList.get(id);
    }
}
