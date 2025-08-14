package eiu.edu.fecse4562231200071.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_Student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @Column(name = "Id", nullable = false, unique = true, columnDefinition = "CHAR(5)")
    @NotBlank(message = "Student ID cannot be blank")
    private String studentId;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters")
    @Pattern(regexp = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯẠ-ỹ][a-zàáâãèéêìíòóôõùúăđĩũơưạ-ỹ']*(\\s)?)+$", message = "Each word must start with an uppercase letter (Vietnamese supported)")
    private String name;

    @Column(name = "year_of_birth", nullable = false, columnDefinition = "YEAR")
    @Min(value = 2000, message = "Year of birth is invalid")
    private int year_of_birth;

    @Column(name = "gpa", nullable = false, columnDefinition = "DECIMAL(3,2)")
    @NotNull(message = "GPA cannot be blank")
    @DecimalMin(value = "0.0", inclusive = true, message = "GPA must be at least 0")
    @DecimalMax(value = "100.0", inclusive = true, message = "GPA must be at most 100")
    private double gpa;

    @ManyToOne
    @JoinColumn(name = "major_id")
    @NotNull(message = "Major must be selected")
    private Major major;

    public Student(String studentId, String name, int year_of_birth, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.year_of_birth = year_of_birth;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth +
                ", gpa=" + gpa +
                '}';
    }
}
