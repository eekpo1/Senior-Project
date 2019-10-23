package com.tablesdemo.model

import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import javax.persistence.*


@Entity
class Admin(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long, var firstName: String, var lastName: String, var login: String, var password: String) {


    @OneToMany(mappedBy = "instructor")
    lateinit var courses: Set<Course>


    @PostPersist
    @PostUpdate
    fun onPersist(): Unit {
        val encoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
        password = encoder.encode(password)
    }
}