package eiu.edu.fecse4562231200071.controller;

import eiu.edu.fecse4562231200071.entity.Student;
import eiu.edu.fecse4562231200071.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public String studentPage(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student-list"; // This should match the name of your HTML template file
    }
}
