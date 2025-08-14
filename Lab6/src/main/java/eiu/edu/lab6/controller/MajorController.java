package eiu.edu.lab6.controller;


import eiu.edu.lab6.entity.Major;
import eiu.edu.lab6.repo.MajorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/majors")
public class MajorController {

    private final MajorRepository majorRepo;

    public MajorController(MajorRepository majorRepo) {
        this.majorRepo = majorRepo;
    }

    // List all majors
    @GetMapping
    public String listMajors(Model model) {
        model.addAttribute("majors", majorRepo.findAll());
        return "majors_list";
    }

    // Show create form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("major", new Major());
        return "major_form";
    }

    // Save new major
    @PostMapping
    public String saveMajor(@ModelAttribute Major major) {
        majorRepo.save(major);
        return "redirect:/majors";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Major major = majorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid major Id:" + id));
        model.addAttribute("major", major);
        return "major_form";
    }

    // Update major
    @PostMapping("/update/{id}")
    public String updateMajor(@PathVariable("id") int id, @ModelAttribute Major major) {
        major.setId(id);
        majorRepo.save(major);
        return "redirect:/majors";
    }

    // Delete major
    @GetMapping("/delete/{id}")
    public String deleteMajor(@PathVariable("id") int id) {
        Major major = majorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid major Id:" + id));
        majorRepo.delete(major);
        return "redirect:/majors";
    }
}