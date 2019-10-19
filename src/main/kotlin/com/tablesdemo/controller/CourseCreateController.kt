package com.tablesdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class CourseCreateController {

    @RequestMapping("/coursecreate.html")
    fun courseCreate(): String = "coursecreate"

}