package edu.eiu.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Subject {
    @Id
    @Column(name = "Code", columnDefinition = "CHAR(10)")
    private String Code;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String Name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(255)")
    private String Description;

    @Column(name = "Credits", columnDefinition = "INT")
    private int Credits;

    @Column(name = "StudyHours", columnDefinition = "INT")
    private int StudyHours;
}
