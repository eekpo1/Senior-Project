package com.tablesdemo.controller

import com.tablesdemo.model.Course
import com.tablesdemo.model.Student
import com.tablesdemo.model.SyllabusWrapper
import com.tablesdemo.repository.CourseRepository
import com.tablesdemo.service.CourseCreationService
import com.tablesdemo.service.SyllabusService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal
import javax.validation.Valid

@Controller
class ProfessorController {

    @Autowired
    lateinit var courseService: CourseCreationService

    @Autowired lateinit var syllabusService: SyllabusService

    @Autowired
    lateinit var courseRepository: CourseRepository

    lateinit var tempCourse: Course

    @RequestMapping("/createsyllabus.html")
    fun createSyllabus(@Valid info: SyllabusWrapper): String {
        syllabusService.createSyllabus(tempCourse, info)
        return "redirect:/home.html"
    }

    @GetMapping("/coursecreate.html")
    fun courseCreate(): String = "coursecreate"


    @PostMapping(value = ["/coursecreate.html"])
    fun create(@Valid course: Course, roster: Model, @Valid student: Student, principal: Principal, result: BindingResult): String {
//        var students = Roster()
//        roster.addAttribute("roster", students)
        tempCourse = courseService.onCreate(course, student, principal)
//        courseService.onCreate(course, student.students, principal)
        return "createsyllabus"
    }

    @GetMapping("courseview/course={id}")
    fun courseAndStudents(model: Model,
                          @PathVariable id: Long): String {
        val course: Course = courseRepository.findById(id).orElse(courseRepository.findAll().first())
        val roster = course.roster
        model.addAttribute("roster", roster)
        model.addAttribute("courses", courseRepository.findAll())

        return "courseview"
    }

    @GetMapping("/courseview.html")
    fun courseView(model: Model): String {
        model.addAttribute("courses", courseRepository.findAll())
        println("courseviewwww")
        return "courseview"
    }

}