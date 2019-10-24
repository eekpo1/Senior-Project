package com.tablesdemo.model

import java.io.Serializable
import javax.persistence.*

@Entity
data class Course(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0, var name: String = "",
             var updated: Boolean = false, var section: String = "", @Embedded var syllabus: Syllabus?) : Serializable {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor")
    lateinit var instructor: Admin

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable (name = "students_in", joinColumns = [JoinColumn(name = "student_id")],
            inverseJoinColumns = [JoinColumn(name = "course_id")])
    lateinit var roster: MutableSet<Student>

    @PreUpdate
    fun checkUpdate(): Unit {
        // Difference between last update and current update
        updated = syllabus?.lastUpdate!! < syllabus?.currentUpate
    }

    init {
        instructor = Admin(firstName = "", lastName = "", username = "", schoolID = 0)
        roster = mutableSetOf()
    }


}