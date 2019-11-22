package com.tablesdemo.controller

import com.tablesdemo.model.Student
import com.tablesdemo.service.StudentCreationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
class StudentController {

    @Autowired lateinit var studentService: StudentCreationService

    @RequestMapping("studentadd.html")
    fun addStudent(@Valid student: Student): String {
        student.username = student.firstName[0].toLowerCase().plus(student.lastName.toLowerCase())
        studentService.createStudent(student)
        return "redirect:/studentadd.html"
    }
}