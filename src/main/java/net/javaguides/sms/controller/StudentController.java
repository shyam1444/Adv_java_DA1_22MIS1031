package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    // Root endpoint - redirect to complaints list
    @GetMapping("/")
    public String home() {
        return "redirect:/complaints";
    }

    // Health check endpoint
    @GetMapping("/health")
    @ResponseBody
    public String health() {
        return "Application is running!";
    }
}
