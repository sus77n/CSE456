package eiu.edu.fecse4562231200071.controller;

import eiu.edu.fecse4562231200071.entity.Major;
import eiu.edu.fecse4562231200071.entity.Student;
import eiu.edu.fecse4562231200071.service.MajorService;
import eiu.edu.fecse4562231200071.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @GetMapping("/students")
    public String studentPage(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student-list"; // This should match the name of your HTML template file
    }

    @GetMapping("/students/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("majors", majorService.getAllMajors());
        return "student-form";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") @Valid Student student, BindingResult result, Model model) {
        // Validation logic (manual, as Student entity has no annotations yet)
        String namePattern = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯẠ-ỹ][a-zàáâãèéêìíòóôõùúăđĩũơưạ-ỹ']*(\\s)?)+$";
        int age = 2025 - student.getYear_of_birth();
        if (student.getName() == null || student.getName().trim().isEmpty() || student.getName().length() < 5 || student.getName().length() > 100 || !student.getName().matches(namePattern)) {
            result.rejectValue("name", "error.student", "Name must be 5-100 chars, not blank, each word capitalized (Vietnamese supported)");
        }
        if (age < 18 || age > 25) {
            result.rejectValue("year_of_birth", "error.student", "Age must be between 18 and 25");
        }
        if (Double.isNaN(student.getGpa()) || student.getGpa() < 0 || student.getGpa() > 100) {
            result.rejectValue("gpa", "error.student", "GPA must be on a 100-point scale and not blank");
        }
        if (result.hasErrors()) {
            model.addAttribute("majors", majorService.getAllMajors());
            return "student-form";
        }
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) return "redirect:/students";
        model.addAttribute("student", student);
        model.addAttribute("majors", majorService.getAllMajors());
        return "student-form";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        Student student = studentService.getStudentById(id);
        if (student != null) studentService.deleteStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/search")
    public String searchStudents(@RequestParam("name") String name, Model model) {
        List<Student> students = studentService.searchByName(name);
        model.addAttribute("students", students);
        return "student-list";
    }
}
