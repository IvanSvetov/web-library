package skypro.java.course4.weblibrary.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import skypro.java.course4.weblibrary.controller.dto.EmployeeDTO;
import skypro.java.course4.weblibrary.controller.dto.EmployeeToDTO;
import skypro.java.course4.weblibrary.model.Employee;
import skypro.java.course4.weblibrary.repository.EmployeePages;
import skypro.java.course4.weblibrary.repository.EmployeeRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeePages employeePages;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeePages employeePages) {
        this.employeeRepository = employeeRepository;
        this.employeePages = employeePages;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return EmployeeToDTO.fromEmployee(employees);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getAllEmployeesByNameAndSalary(String name, int salary) {
        return employeeRepository.findByNameAndSalary(name, salary);
    }

    @Override
    public List<EmployeeDTO> getEmployeeWithHighestSalary() {
        return EmployeeToDTO.fromEmployee(employeeRepository.findEmployeeWithBiggestSalary());
    }

    @Override
    public List<EmployeeDTO> getEmployeeByPosition(int positionId) {
        return EmployeeToDTO.fromEmployee(employeeRepository.findAllByPositionId(positionId));
    }

    @Override
    public List<EmployeeDTO> getEmployeeByPage(int pageIndex) {
        Pageable employeeOfConcretePage = PageRequest.of(pageIndex, 10);
        Page<Employee> page = employeePages.findAll(employeeOfConcretePage);
        return EmployeeToDTO.fromEmployee(page.stream().toList());
    }


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


//    @Override
//    public Employee getEmployeeByID(Long id) {
//        return employeeRepository.getEmployeeByID(id);
//    }
//
//    @Override
//    public Employee add(Employee employee) {
//        return employeeRepository.addEmployee(employee);
//    }
//
//    @Override
//    public void remove(Long id) {
//        employeeRepository.removeEmployee(id);
//    }
//
//
//    @Override
//    public Employee editEmployee(Employee employee, Long id) {
//        return employeeRepository.editEmployee(id, employee);
//    }
//
//
//
//    @Override
//    public Collection<Employee> salaryHighterThan(Integer compareSalary) {
//        Collection<Employee> salaryHighter = new ArrayList<>();
//        for (Employee employee : findAll()) {
//            if (employee.getSalary() > compareSalary) {
//                salaryHighter.add(employee);
//            }
//        }
//        return salaryHighter;
//    }




//              NOT USE



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
