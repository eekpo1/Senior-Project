package com.tablesdemo.model

import javax.persistence.*


@Entity
data class Admin(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0, var firstName: String,
                 var lastName: String, @Column(name = "username", nullable = true) var username: String?, @Column(name = "school_id") var schoolID: Long) {

    @OneToMany(mappedBy = "instructor")
    lateinit var courses: Set<Course>


}