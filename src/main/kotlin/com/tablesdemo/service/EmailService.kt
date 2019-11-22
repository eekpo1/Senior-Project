package com.tablesdemo.service

import com.tablesdemo.model.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService {

    @Autowired private lateinit var mailer: JavaMailSender


    private val school = "CSUB"



    fun sendStudent(student: Student, pass: String,  to: String, subject: String) {
        var template = "Welcome to WhatsDuem $school ${student.firstName} ${student.lastName}! Your Journey " +
                "through university just got easier!" +
                "Your details are: Username: ${student.username} Password: $pass. Upon login, You will " +
                "only be able to see the link to the app and the ability to change your password, which you will be" +
                " able to do either on the application or the website. "

        val message = SimpleMailMessage()
        message.setTo(to)
        message.setSubject(subject)
        message.setText(template)

        mailer.send(message)
    }
}