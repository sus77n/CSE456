package edu.eiu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "Majors")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"students"})

public class Major {
    @Id
    @Column(name = "majorId", columnDefinition = "CHAR(4)")
    private String majorId;

    @Column(name = "majorName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String majorName;

    @ManyToOne
    private School school;

    @OneToMany(mappedBy = "major")
    private java.util.List<Student> students;

    public  Major(String majorId, String majorName) {
        this.majorId = majorId;
        this.majorName = majorName;
    }
}
