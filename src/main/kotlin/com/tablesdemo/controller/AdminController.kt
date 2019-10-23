package com.tablesdemo.controller

import com.tablesdemo.model.Admin
import com.tablesdemo.model.User
import com.tablesdemo.repository.AdminRepository
import com.tablesdemo.repository.StudentRepository
import com.tablesdemo.repository.UserRepository
import com.tablesdemo.service.PasswordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
class AdminController {

    @Autowired
    lateinit var studentRepository: StudentRepository
    @Autowired
    lateinit var adminRepository: AdminRepository
    @Autowired
    lateinit var userRepository: UserRepository


    @Autowired
    lateinit var passwordService: PasswordService

    @GetMapping("/studentadd.html")
    fun studentAdd(): String {
        return "studentadd"
    }


    @RequestMapping("/adminadd.html")
    fun adminAdd(): String = "adminadd"


    @PostMapping(value = ["/adminadd.html"])
    fun persistAdministrator(@Valid admin: Admin): String {
        admin.firstName.toLowerCase()
        admin.lastName.toLowerCase()
        admin.username = admin.firstName[0].plus(admin.lastName)
        userRepository.save(User(admin.username, passwordService.createPassword(), true))
        adminRepository.saveAndFlush(admin)
        return "redirect:/home.html"
    }
}