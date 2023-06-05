package skypro.java.course4.weblibrary.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private final String firstName;
    @NotBlank(message = "Name is mandatory")
    @NotNull
    private final String lastName;
    @Positive
    private int salary;
    @NotNull
    private int departmentId;
}
