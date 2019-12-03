package com.tablesdemo.controller

import com.tablesdemo.repository.AdminRepository
import com.tablesdemo.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.security.Principal

@Controller
class HomeController {

    @Autowired
    lateinit var studentRepository: StudentRepository
    @Autowired
    lateinit var adminRepository: AdminRepository

    @RequestMapping("/home.html", "/", method = [RequestMethod.GET])
    fun home(model: Model, principal: Principal): String {
        model.addAttribute("loggedUser", adminRepository.findByUsername(principal.name))
        return "home"
    }


}