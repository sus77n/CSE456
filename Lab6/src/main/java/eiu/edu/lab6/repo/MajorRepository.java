package eiu.edu.lab6.repo;

import eiu.edu.lab6.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Integer> {
}