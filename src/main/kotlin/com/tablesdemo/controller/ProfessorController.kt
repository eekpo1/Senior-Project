package com.tablesdemo.controller

import com.tablesdemo.model.Course
import com.tablesdemo.model.Roster
import com.tablesdemo.model.Student
import com.tablesdemo.repository.CourseRepository
import com.tablesdemo.service.CourseCreationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal
import javax.validation.Valid

@Controller
class ProfessorController {

    @Autowired
    lateinit var courseService: CourseCreationService

    @Autowired
    lateinit var courseRepository: CourseRepository

    @RequestMapping("/createsyllabus.html")
    fun createSyllabus(): String = "createsyllabus"

    @GetMapping("/coursecreate.html")
    fun courseCreate(): String = "coursecreate"

    @PostMapping(value = ["/coursecreate.html"])
    fun create(@Valid course: Course, @Valid student: Student, roster: Roster, principal: Principal, result: BindingResult): String {
//        courseService.onCreate(course, roster, principal)
        courseService.onCreate(course, student, principal)
        return "coursecreate"
    }

    @GetMapping("/courseview.html")
    fun courseView(model: Model): String {
        model.addAttribute("courses", courseRepository.findAll())
        return "courseview"
    }

    @GetMapping("/courseview.html?students")
    fun courseAndStudents(): String {
        return "courseview"
    }
}