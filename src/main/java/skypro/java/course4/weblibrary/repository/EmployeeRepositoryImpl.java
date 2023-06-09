package skypro.java.course4.weblibrary.repository;

import org.springframework.stereotype.Repository;
import skypro.java.course4.weblibrary.exceptions.EmployeeNotFoudExeption;
import skypro.java.course4.weblibrary.model.Employee;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Repository
//public class EmployeeRepositoryImpl implements EmployeeRepository{
//    private Long idGenerator = 1L;
//    private final List<Employee> employeeList = Stream.of(
//            new Employee(idGenerator++,"Катя", "Ivanova", 48000, 1),
//            new Employee(idGenerator++,"Дима", "Petrova", 56000, 1),
//            new Employee(idGenerator++,"Олег", "Deeva", 37000, 2),
//            new Employee(idGenerator++,"Вика", "Zolova",35000, 3)).collect(Collectors.toList());
//
//    @Override
//    public List<Employee> getAllEmployees() {
//        return employeeList;
//    }
//
//    @Override
//    public Employee getEmployeeByID(Long id) {
//        for (Employee employee : employeeList) {
//            if (employee.getId().equals(id)) {
//                return employee;
//            }
//        }
//        throw new EmployeeNotFoudExeption();
//    }
//    @Override
//    public Employee addEmployee(Employee employee) {
//        employee.setId(idGenerator++);
//        employeeList.add(employee);
//        return employee;
//    }
//    @Override
//    public void removeEmployee(Long id) {
//        int index = - 1;
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (employeeList.get(i).getId().equals(id)) {
//                index = i;
//                break;
//            }
//        }
//        if (index == -1) {
//            throw new EmployeeNotFoudExeption();
//        }
//    }
//
//    @Override
//    public Employee editEmployee(Long id, Employee employee) {
//        int index = - 1;
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (employeeList.get(i).getId().equals(id)) {
//                index = i;
//                employeeList.set(i, employee);
//                break;
//            }
//        }
//        if (index == -1) {
//            throw new EmployeeNotFoudExeption();
//        }
//        return employeeList.get(index);
//    }
//
//}
