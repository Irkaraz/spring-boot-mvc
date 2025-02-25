package com.irkaraz.springboot.thymeleafdemo.controller;

import com.irkaraz.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programLanguages}")
    private List<String> programLanguages;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        theModel.addAttribute("student", new Student());

        // add the list of countries to the model
        theModel.addAttribute("countries", countries);

        // add the list of program languages to the model
        theModel.addAttribute("programLanguages", programLanguages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
