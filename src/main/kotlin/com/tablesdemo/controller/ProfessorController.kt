package com.tablesdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ProfessorController {

    @RequestMapping("/createsyllabus.html")
    fun createSyllabus(): String = "createsyllabus"

    @RequestMapping("/coursecreate.html")
    fun courseCreate(): String = "coursecreate"

    @RequestMapping("/courseview.html")
    fun courseView(): String = "courseview"
}