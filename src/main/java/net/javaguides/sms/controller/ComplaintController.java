package net.javaguides.sms.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

@Controller
public class ComplaintController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/complaints")
    public String listComplaints(Model model) {
        List<Student> complaints = studentService.getAllStudents();
        model.addAttribute("complaints", complaints);
        return "complaints";
    }

    @GetMapping("/complaints/new")
    public String createComplaintForm(Model model) {
        model.addAttribute("complaint", new Student());
        return "create_student"; // keeping existing template name
    }

    @PostMapping("/complaints")
    public String saveComplaint(@ModelAttribute("complaint") Student complaint) {
        if (complaint.getDate() == null) {
            complaint.setDate(LocalDateTime.now());
        }
        if (complaint.getStatus() == null || complaint.getStatus().isBlank()) {
            complaint.setStatus("Pending");
        }
        studentService.saveStudent(complaint);
        return "redirect:/complaints";
    }

    @GetMapping("/complaints/edit/{id}")
    public String editComplaintForm(@PathVariable Long id, Model model) {
        Student existing = studentService.getStudentById(id);
        if (existing == null) {
            return "redirect:/complaints";
        }
        model.addAttribute("complaint", existing);
        return "edit_student"; // keeping existing template name
    }

    @PostMapping("/complaints/{id}")
    public String updateComplaint(@PathVariable Long id, @ModelAttribute("complaint") Student complaint) {
        Student existing = studentService.getStudentById(id);
        if (existing == null) {
            return "redirect:/complaints";
        }
        complaint.setId(id);
        if (complaint.getDate() == null) {
            complaint.setDate(LocalDateTime.now());
        }
        if (complaint.getStatus() == null || complaint.getStatus().isBlank()) {
            complaint.setStatus("Pending");
        }
        studentService.updateStudent(complaint);
        return "redirect:/complaints";
    }

    @GetMapping("/complaints/{id}")
    public String deleteComplaint(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/complaints";
    }
}
