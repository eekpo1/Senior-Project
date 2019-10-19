package com.tablesdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class CreateSyllabusView {

    @RequestMapping("/createsyllabus.html")
    fun createSyllabus(): String = "createsyllabus"

}