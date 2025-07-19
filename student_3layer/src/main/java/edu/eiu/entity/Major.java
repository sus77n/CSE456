package edu.eiu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Majors")
@NoArgsConstructor
@AllArgsConstructor

public class Major {

    @Id
    @Column(name = "majorId", columnDefinition = "CHAR(4)")
    private String majorId;

    @Column(name = "majorName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String majorName;

    @ManyToOne
    private School school;
}
