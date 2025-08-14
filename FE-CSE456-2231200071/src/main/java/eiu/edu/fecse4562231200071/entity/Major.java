package eiu.edu.fecse4562231200071.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_Major")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "major", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
        student.setMajor(this);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
        student.setMajor(null); // Ensure the relationship is also removed from the Student entity
    }

    public Major(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
