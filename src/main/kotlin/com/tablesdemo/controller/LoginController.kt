package com.tablesdemo.controller


import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class LoginController {

    @RequestMapping("/login-page.html")
    fun logMeIn(): String = "login-page"


    @RequestMapping("/login-error.html")
    fun loginError(model: Model): String {
        model.addAttribute("loginError", true)
        return "login-error"
    }

    @RequestMapping("/index", "/")
    fun hello(): String = "hello"




}