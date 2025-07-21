package edu.eiu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Schools")
@Entity
@ToString(exclude = {"students", "majors"})

public class School {
    @Id
    @Column(name = "schoolId", columnDefinition = "CHAR(3)")
    private String schoolId;

    @Column(name = "schoolName", columnDefinition = "VARCHAR(100)", nullable = false)
    private String schoolName;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER)
    private List<Student> students;

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER)
    private List<Major> majors;

    public School(String schoolId, String schoolName, String location) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.location = location;
    }

}
