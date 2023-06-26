package skypro.java.course4.weblibrary.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import skypro.java.course4.weblibrary.controller.dto.EmployeeDTO;
import skypro.java.course4.weblibrary.controller.dto.EmployeeToDTO;
import skypro.java.course4.weblibrary.controller.dto.ReportDTO;
import skypro.java.course4.weblibrary.controller.dto.UploadEmployeeDTO;
import skypro.java.course4.weblibrary.exceptions.IllegalJsonFileExeption;
import skypro.java.course4.weblibrary.exceptions.InternalServerError;
import skypro.java.course4.weblibrary.exceptions.ReportNotFoundExeption;
import skypro.java.course4.weblibrary.model.Employee;
import skypro.java.course4.weblibrary.model.Position;
import skypro.java.course4.weblibrary.model.Report;
import skypro.java.course4.weblibrary.repository.EmployeePages;
import skypro.java.course4.weblibrary.repository.EmployeeRepository;
import skypro.java.course4.weblibrary.repository.PositionRepository;
import skypro.java.course4.weblibrary.repository.ReportRepository;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeePages employeePages;
    private final ObjectMapper objectMapper;
    private final ReportRepository reportRepository;
    private final PositionRepository positionRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeePages employeePages,
                               ObjectMapper objectMapper,
                               ReportRepository reportRepository,
                               PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.employeePages = employeePages;
        this.objectMapper = objectMapper;
        this.reportRepository = reportRepository;
        this.positionRepository = positionRepository;
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

    @Override
    public void upload(MultipartFile employees) {
        try {
            String extension = StringUtils.getFilenameExtension(employees.getOriginalFilename());
            if (!"json".equals(extension)){
                throw new IllegalJsonFileExeption();
            }
            TypeReference<List<UploadEmployeeDTO>> ref = new TypeReference<>() {
            };
            var uploadEmployeeDTOS = objectMapper.readValue(employees.getInputStream(),
                    ref);
            Map<Integer, Position> positionMap = new HashMap<>();
            positionRepository.findAllById(uploadEmployeeDTOS.stream()
                    .map(UploadEmployeeDTO::getPositionId)
                    .distinct()
                    .toList()).forEach(x-> positionMap.put(x.getId(),x));

            employeeRepository.saveAll(uploadEmployeeDTOS.stream().map(x-> EmployeeToDTO.toEmployee(x,positionMap)).toList());

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalJsonFileExeption();
        }
    }

    @Override
    public int report() {
        try {
            Report report = new Report();
            report.setReport(buildReport());
            return reportRepository.save(report).getId();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new InternalServerError();
        }

    }

    public String buildReport() throws JsonProcessingException {
        List<ReportDTO> reports = employeeRepository.buildReports();
        return objectMapper.writeValueAsString(reports);
    }

    @Override
    public Resource downloadReport(int id) {
        return new ByteArrayResource(
                reportRepository.findById(id)
                        .orElseThrow(ReportNotFoundExeption::new)
                        .getReport()
                        .getBytes(StandardCharsets.UTF_8)
        );
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
