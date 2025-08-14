package eiu.edu.lab6;
import eiu.edu.lab6.entity.Major;
import eiu.edu.lab6.entity.Student;
import eiu.edu.lab6.repo.MajorRepository;
import eiu.edu.lab6.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MajorRepository majorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Major cs = new Major("Computer Science");
        Major it = new Major("Information Technology");

        majorRepository.save(cs);
        majorRepository.save(it);

        studentRepository.save(new Student("Alice", 2000, 3.5, cs,cs.getId()));
        studentRepository.save(new Student("Bob", 1999, 3.8, cs, cs.getId()));
        studentRepository.save(new Student("Charlie", 2001, 3.2, it, it.getId()));

        System.out.println("Sample data inserted!");
    }
}

