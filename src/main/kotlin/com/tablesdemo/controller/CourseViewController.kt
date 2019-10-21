package com.tablesdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class CourseViewController {

    @RequestMapping("/courseview.html")
    fun courseView(): String = "courseview"



}