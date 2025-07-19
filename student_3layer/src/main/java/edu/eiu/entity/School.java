package edu.eiu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Schools")
@Entity

public class School {
    @Id
    @Column(name = "schoolId", columnDefinition = "CHAR(3)")
    private String schoolId;

    @Column(name = "schoolName", columnDefinition = "VARCHAR(100)", nullable = false)
    private String schoolName;

    @Column(name = "location")
    private String location;
}
