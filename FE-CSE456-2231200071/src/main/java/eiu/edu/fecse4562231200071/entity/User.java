package eiu.edu.fecse4562231200071.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(255)")
    private  String password;

    @Column(name = "role", nullable = false, columnDefinition = "INT")
    private int role;

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
