package eiu.edu.fecse4562231200071.repo;

import eiu.edu.fecse4562231200071.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,String> {
    List<Student> findByNameContainingIgnoreCase(String name);
}
