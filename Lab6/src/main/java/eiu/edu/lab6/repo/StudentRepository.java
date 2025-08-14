package eiu.edu.lab6.repo;


import eiu.edu.lab6.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}