package com.tablesdemo.model

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

class SyllabusWrapper(var phone: String = "", var email: String = "", var officeHrs: String = "",
                      var start: String = "" , var end: String = "", var Assignments: String,
                      var due: String) {

    /**
     * Should make the office hours a MutableList<String> and the assignments a MutableList<String>
     */
}