package skypro.java.course4.weblibrary.service;

import org.springframework.stereotype.Service;
import skypro.java.course4.weblibrary.exceptions.EmployeeExceptionHandler;
import skypro.java.course4.weblibrary.model.Employee;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final Map<Long, Employee> employees;


    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Employee getEmployeeByID(Long id) {
        if (!employees.containsKey(id)) {
            throw new EmployeeExceptionHandler();
        }
        return employees.get(id);
    }

    @Override
    public Employee add(Employee employee) {
        if (!employees.containsKey(employee.getId())){
            throw new EmployeeExceptionHandler();
        }
        Employee createEmployee = employees.put((long) employee.getId(), employee);

        return createEmployee;
    }

    @Override
    public void remove(Long id) {
        if (!employees.containsKey(id)) {
            throw new EmployeeExceptionHandler();
        }
        Employee employee = employees.remove(id);
    }

    @Override
    public Employee find(Long id) {
        if (employees.containsKey(id)) {
        }
        return employees.get(id);
    }

    @Override
    public Employee edit(Employee employee) {
        if (!employees.containsKey(employee.getId())) {
            throw new EmployeeExceptionHandler();
        }
        Employee updated = employees.put((long) employee.getId(), employee);
        return updated;
    }

    @Override
    public Collection<Employee> findAll() {
        return (Collection<Employee>) employees;
    }


//    @Override
//    public Employee getEmployeeByID(List<Employee> employeeList) {
//
//        return employeeRepository.getEmployeeByID();
//    }
//
//
//
//    @Override
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.getAllEmployees();
//    }
//
//
//    @Override
//    public String salarySum(List<Employee> employeeList) {
//        int salarysum = 0;
//        for (int i = 0; i < employeeList.size(); i++) {
//            salarysum = salarysum + employeeList.get(i).getSalary();
//        }
//        return "Сумма зарплат сотрудников составляет " + salarysum;
//    }
//
//    @Override
//    public String salaryMin(List<Employee> employeeList) {
//        int minSalary = 60000;
//        String minEmployer = null;
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (employeeList.get(i).getSalary() < minSalary) {
//                minSalary = employeeList.get(i).getSalary();
//                minEmployer = employeeList.get(i).getName();
//            }
//        }
//        return "Сотрудник с минимальной зарплатой " + minEmployer + " " + minSalary;
//    }
//
//    @Override
//    public String salaryMax(List<Employee> employeeList) {
//        int maxSalary = 0;
//        String maxEmployer = null;
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (employeeList.get(i).getSalary() > maxSalary) {
//                maxSalary = employeeList.get(i).getSalary();
//                maxEmployer = employeeList.get(i).getName();
//            }
//        }
//        return "Сотрудник с максимальной зарплатой " + maxEmployer + " " + maxSalary ;
//    }
//
//    @Override
//    public String getAvg(List<Employee> employeeList) {
//        int average = 0;
//        if (employeeList.size() > 0) {
//            int sum = 0;
//            for (int i = 0; i < employeeList.size(); i++) {
//                sum += employeeList.get(i).getSalary();
//            }
//            average = sum / employeeList.size();
//        }
//
//
//        return "Средняя зарплата сотрудников " + average;
//    }
//
//    @Override
//    public String getMoreThanAvg(List<Employee> employeeList) {
//        List<Employee> moreThanAvg = null;
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (employeeList.get(i).getSalary() > employeeList.get(i).getSalary()) {
//                moreThanAvg.add(employeeList.get(i));
//            }
//        }
//        return "Сотрудники с зарплатой выше средней " + moreThanAvg;
//    }

}
