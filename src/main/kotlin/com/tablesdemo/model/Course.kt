package com.tablesdemo.model

import java.io.Serializable
import javax.persistence.*

@Entity
class Course(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0, var name: String = "",
             var updated: Boolean, var section: String = "", @Embedded var syllabus: Syllabus) : Serializable {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor")
    lateinit var instructor: Admin

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable (name = "students_in", joinColumns = [JoinColumn(name = "student_id")],
            inverseJoinColumns = [JoinColumn(name = "course_id")])
    lateinit var roster: Set<Student>


}