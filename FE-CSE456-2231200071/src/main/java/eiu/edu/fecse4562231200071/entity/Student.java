package eiu.edu.fecse4562231200071.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "Id", nullable = false, unique = true, columnDefinition = "CHAR(5)")
    private String studentId;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "year_of_birth", nullable = false, columnDefinition = "YEAR")
    private int year_of_birth;

    @Column(name = "gpa", nullable = false, columnDefinition = "DECIMAL(3,2)")
    private double gpa;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    public Student(String studentId, String name, int year_of_birth, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.year_of_birth = year_of_birth;
        this.gpa = gpa;
    }

}
