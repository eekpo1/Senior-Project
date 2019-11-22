package com.tablesdemo.model

import java.io.Serializable
import javax.persistence.*

@Entity
class Student(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0, var firstName: String,
              var lastName: String, @Column(name = "username") var username: String?) : Serializable { // Lets omit schedule for now and talk more about it later

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST, CascadeType.MERGE], mappedBy = "roster")
    var coursesIn: MutableSet<Course> = mutableSetOf()

//    @OneToOne
//    lateinit var userId: User


}