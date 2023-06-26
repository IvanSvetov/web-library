package skypro.java.course4.weblibrary.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadEmployeeDTO {
    private String name;
    private Integer salary;
    private int positionId;
}
