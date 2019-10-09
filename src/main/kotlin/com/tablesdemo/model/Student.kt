package com.tablesdemo.model

import java.io.Serializable
import javax.persistence.*

@Entity
class Student(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0, var firstName: String = "",
              var lastName: String = "") : Serializable { // Lets omit schedule for now and talk more about it later

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE], mappedBy = "roster")
    lateinit var coursesIn: Set<Course>

//    @OneToOne
//    lateinit var userId: User

}