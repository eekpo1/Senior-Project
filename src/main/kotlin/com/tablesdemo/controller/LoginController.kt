package com.tablesdemo.controller


import com.tablesdemo.repository.StudentRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class LoginController {

    lateinit var studentRepository: StudentRepository

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