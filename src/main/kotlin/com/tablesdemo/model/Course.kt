package com.tablesdemo.model

import java.io.Serializable
import javax.persistence.*

@Entity
data class Course(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0, var name: String = "",
             var updated: Boolean = false, var section: String = "", @Embedded var syllabus: Syllabus?) : Serializable {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor")
    var instructor = Admin(firstName = "", lastName = "", username = "", schoolID = 0)

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable (name = "students_in", joinColumns = [JoinColumn(name = "student_id")],
            inverseJoinColumns = [JoinColumn(name = "course_id")])
    var roster: MutableSet<Student> = mutableSetOf()

    @PreUpdate
    fun checkUpdate(): Unit {
        // Difference between last update and current update
        updated = syllabus?.lastUpdate!! < syllabus?.currentUpdate
    }


}