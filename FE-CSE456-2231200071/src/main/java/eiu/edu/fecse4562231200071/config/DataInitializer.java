package eiu.edu.fecse4562231200071.config;

import eiu.edu.fecse4562231200071.entity.Major;
import eiu.edu.fecse4562231200071.entity.Student;
import eiu.edu.fecse4562231200071.service.MajorService;
import eiu.edu.fecse4562231200071.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    MajorService majorService;

    @Autowired
    StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        Major m1 = new Major("Computer Science","CS");
        Major m2 = new Major("Software Engineering","SF");

        majorService.save(m1);
        majorService.save(m2);

        Student s1 = new Student("st1m1", "John",2000, 3.9, m1);
        Student s2 = new Student("st2m1", "Jane",2001, 3.7, m1);
        Student s3 = new Student("st3m2", "Jun",2000, 3.5, m2);

        studentService.saveStudent(s1);
        studentService.saveStudent(s2);
        studentService.saveStudent(s3);

    }
}
