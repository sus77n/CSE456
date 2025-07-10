package edu.eiu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lecturers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer {
    @Id
    @Column(name = "ID", columnDefinition = "INT")
    private int Id;

    @Column(name = "Salary", columnDefinition = "DOUBLE")
    private double Salary;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String Name;

    @Column(name = "YOB", nullable = false)
    private int Yob;
}
