package com.tablesdemo.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "authorities")
data class Roles(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0, @Column(insertable = true, updatable = true)var username: String, @Column(nullable = false) var authority: String = "") : Serializable{
//    @JoinColumn(name = "username", referencedColumnName = "username")
//    @OneToOne(fetch = FetchType.EAGER)
//    @Column()
//    lateinit var user: User

//    init {
//        username = user.username.toString()
//    }


}