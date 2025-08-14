package eiu.edu.lab6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String name;

    private Integer yearOfBirth;

    private double gpa;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @Transient
    private int majorId = -1; // Default value for form binding

    // Getter and setter for majorId for form binding
    public int getMajorId() {
        return major != null ? major.getId() : null;
    }

    public Student(String name, Integer yearOfBirth, Double gpa, Major major, Integer otherField) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
        this.major = major;
        // set other fields
    }

}