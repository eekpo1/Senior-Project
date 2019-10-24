package com.tablesdemo.model

import javax.validation.Valid

// Haven't made this an entity yet. I dont think we need to
class Roster {

    @Valid
    val students = mutableListOf<Student>()
    var student = Student(firstName = "", lastName = "", username = "")

    fun addStudent(firstName: String, lastName: String) {
        students.add(Student(firstName = firstName, lastName = lastName, username = firstName[0].plus(lastName)))
    }

    companion object


}