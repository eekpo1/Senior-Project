package com.tablesdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class PhomeController {

    @RequestMapping("/phome.html")
    fun phome(): String = "phome"

}