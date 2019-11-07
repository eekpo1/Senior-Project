package com.tablesdemo.model

// Haven't made this an entity yet. I dont think we need to
class Roster {

    val students = mutableListOf<Student>()


    fun addStudent(firstName: String, lastName: String) {
        students.add(Student(firstName = firstName, lastName = lastName, username = ""))
    }

    init {
        for (i in 0..10)
            addStudent("", "")

    }


}