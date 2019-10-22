package com.tablesdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class   AdminController {

    @RequestMapping("/studentadd.html")
    fun studentAdd(): String = "studentadd"

    @RequestMapping("/adminadd.html")
    fun adminAdd(): String = "adminadd"
}