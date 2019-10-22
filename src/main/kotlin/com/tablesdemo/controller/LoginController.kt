package com.tablesdemo.controller


import com.tablesdemo.repository.StudentRepository
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


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

    @RequestMapping("/logout", method = [RequestMethod.POST])
    fun logOut(request: HttpServletRequest, response: HttpServletResponse): String {
        val auth = SecurityContextHolder.getContext().authentication
        if (auth == null) SecurityContextLogoutHandler().logout(request, response, auth)
        return "redirect:/login-page"
    }


}