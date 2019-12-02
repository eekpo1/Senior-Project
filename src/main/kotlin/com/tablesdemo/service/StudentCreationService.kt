package com.tablesdemo.service

import com.tablesdemo.model.Roles
import com.tablesdemo.model.Student
import com.tablesdemo.model.User
import com.tablesdemo.repository.RolesRepository
import com.tablesdemo.repository.StudentRepository
import com.tablesdemo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * This service creates students and their roles. The goal is to separate concerns by avoiding the instantiation of
 * autowired repositories everywhere
 */
@Service
class StudentCreationService {

    @Autowired lateinit var studentRepository: StudentRepository
    @Autowired lateinit var userRepository: UserRepository
    @Autowired lateinit var rolesRepository: RolesRepository
    @Autowired lateinit var passwordService: PasswordService
    @Autowired lateinit var mailService: EmailService


    fun createStudent(student: Student) {
        val password = passwordService.createPassword()
        studentRepository.save(student)
        rolesRepository.save(Roles(username = student.username.toString(), authority = "ROLE_STUDENT"))
        userRepository.saveAndFlush(User(student.username, password.second, true))

        // Sends to Nick by default
        mailService.sendStudent(student, password.first, "nkalar@csub.edu", "Welcome to WhatsDue!")
    }


}