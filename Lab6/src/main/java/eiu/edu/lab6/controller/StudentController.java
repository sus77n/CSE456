package eiu.edu.lab6.controller;

import eiu.edu.lab6.entity.Major;
import eiu.edu.lab6.entity.Student;
import eiu.edu.lab6.repo.MajorRepository;
import eiu.edu.lab6.repo.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepo;
    private final MajorRepository majorRepo;

    public StudentController(StudentRepository studentRepo, MajorRepository majorRepo) {
        this.studentRepo = studentRepo;
        this.majorRepo = majorRepo;
    }

    @GetMapping("")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        return "student_list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("majors", majorRepo.findAll());
        return "student_form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        model.addAttribute("majors", majorRepo.findAll());
        return "student_form";
    }

    // New unified save/update method
    @PostMapping("/save")
    public String saveOrUpdateStudent(@ModelAttribute Student student) {
        if (student.getMajorId() != -1) {
            Major major = majorRepo.findById(student.getMajorId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid major Id:" + student.getMajorId()));
            student.setMajor(major); // attach managed entity
        } else {
            student.setMajor(null);
        }

        studentRepo.save(student); // save student with managed major
        return "redirect:/students";
    }


    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepo.delete(student);
        return "redirect:/students";
    }
}
