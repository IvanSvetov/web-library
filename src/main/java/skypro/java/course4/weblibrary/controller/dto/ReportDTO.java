package skypro.java.course4.weblibrary.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {

    private String position;
    private Long count;
    private int maxSalary;
    private int mimSalary;
    private double averageSalary;
}
