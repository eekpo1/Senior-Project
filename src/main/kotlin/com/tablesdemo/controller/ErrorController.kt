package com.tablesdemo.controller

import org.springframework.http.HttpStatus
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ErrorController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun exception(throwable: Throwable, model: Model): String {
        val errorMessage = throwable.message ?: "Unknown Error"
        model.addAttribute("errorMessage", errorMessage)
        return "login-error"
    }
}