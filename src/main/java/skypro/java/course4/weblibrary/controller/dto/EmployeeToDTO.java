package skypro.java.course4.weblibrary.controller.dto;

import skypro.java.course4.weblibrary.model.Employee;
import skypro.java.course4.weblibrary.model.Position;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeToDTO {
    public static EmployeeDTO fromEmployee(Employee employee){
        String positionName = employee.getPosition() == null ? "No position" : employee.getPosition().getName();
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getSalary(), positionName);
    }
    public static List<EmployeeDTO> fromEmployee(List<Employee> employees) {
        return employees.stream().map(EmployeeToDTO::fromEmployee).collect(Collectors.toList());
    }
    public static Employee toEmployee(UploadEmployeeDTO uploadEmployeeDTO, Map<Integer, Position> positionMap){
        return new Employee(uploadEmployeeDTO.getName(), uploadEmployeeDTO.getSalary(), positionMap.get(uploadEmployeeDTO.getPositionId()));
    }
}
