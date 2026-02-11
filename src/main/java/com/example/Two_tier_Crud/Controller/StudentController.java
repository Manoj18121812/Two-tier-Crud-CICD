package com.example.Two_tier_Crud.Controller;

import com.example.Two_tier_Crud.Entity.Student;
import com.example.Two_tier_Crud.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService studentService) {
        this.service = studentService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("students", service.getAllStudent());
        return "index";
    }

    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "new_student";   // Make sure file name matches
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteByid(id);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "edit_student";
    }
}
