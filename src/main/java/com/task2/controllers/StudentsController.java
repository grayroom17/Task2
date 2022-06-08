package com.task2.controllers;

import com.task2.dao.DAO;
import com.task2.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {

    private DAO dao;

    public StudentsController(DAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = dao.getAllStudents();
        model.addAttribute("students", students);
        return "students/index";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable("id") Integer id, Model model) {
        Student student = dao.getStudentById(id);
        model.addAttribute("student", student);
        return "students/studentById";
    }

    @GetMapping("/new")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "students/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") Student student) {
        dao.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", dao.getStudentById(id));
        return "students/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") Student student) {
        dao.save(student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        dao.delete(id);
        return "redirect:/students";
    }
}
