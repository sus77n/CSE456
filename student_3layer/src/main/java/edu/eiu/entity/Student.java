package edu.eiu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(name = "studentId", columnDefinition = "CHAR(10)")
    private int studentId;

    @Column(name = "fullName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String fullName;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "GPA")
    private double gpa;

    @JoinColumn(name = "schoolId", referencedColumnName = "schoolId", nullable = false)
    @Column(name = "schoolId", columnDefinition = "CHAR(3)", nullable = false)
    private String schoolId;
}