package skypro.java.course4.weblibrary.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Integer salary;
    private String position;

}
