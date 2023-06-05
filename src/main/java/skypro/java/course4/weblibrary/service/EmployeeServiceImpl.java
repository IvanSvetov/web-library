package skypro.java.course4.weblibrary.service;

import org.springframework.stereotype.Service;
import skypro.java.course4.weblibrary.exceptions.EmployeeAlreadyExistsExeption;
import skypro.java.course4.weblibrary.exceptions.EmployeeExceptionHandler;
import skypro.java.course4.weblibrary.exceptions.EmployeeNotFoudExeption;
import skypro.java.course4.weblibrary.model.Employee;
import skypro.java.course4.weblibrary.repository.EmployeeRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeByID(Long id) {
        return employeeRepository.getEmployeeByID(id);
    }

    @Override
    public Employee add(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.removeEmployee(id);
    }


    @Override
    public Employee editEmployee(Employee employee, Long id) {
        return employeeRepository.editEmployee(id, employee);
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Collection<Employee> salaryHighterThan(Integer compareSalary) {
        Collection<Employee> salaryHighter = new ArrayList<>();
        for (Employee employee : findAll()) {
            if (employee.getSalary() > compareSalary) {
                salaryHighter.add(employee);
            }
        }
        return salaryHighter;
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
