package edu.eiu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "Students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"school"})

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

    @Column(name = "enrollmentYear", nullable = false)
    private int enrollmentYear;

    @ManyToOne
    @JoinColumn(name = "schoolId", nullable = false)
    private School school;

    @ManyToOne
    @JoinColumn(name = "majorId", nullable = false)
    private Major major;
}