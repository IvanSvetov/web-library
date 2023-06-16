package skypro.java.course4.weblibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.lang.reflect.Type;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;



//    private Long id;
//    @NotBlank(message = "Name is mandatory")
//    private final String firstName;
//    @NotBlank(message = "Name is mandatory")
//    @NotNull
//    private final String lastName;
//    @Positive
//    private int salary;
//    @NotNull
//    private int departmentId;
}
