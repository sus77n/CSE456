package eiu.edu.fecse4562231200071.service;

import eiu.edu.fecse4562231200071.entity.Student;
import eiu.edu.fecse4562231200071.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void saveStudent(Student student){
        studentRepo.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepo.delete(student);
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepo.findById(id).orElse(null);
    }

    public List<Student> searchByName(String name) {
        return studentRepo.findByNameContainingIgnoreCase(name);
    }
}
