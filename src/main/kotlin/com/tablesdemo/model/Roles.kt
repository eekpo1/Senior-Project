package com.tablesdemo.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "authorities")
class Roles(@Id var username: String, @Column(nullable = false) var authority: String = "") : Serializable {

    @PrimaryKeyJoinColumn(name = "username", referencedColumnName = "username")
    @OneToOne(fetch = FetchType.EAGER)
    lateinit var user: User

    init {
        username = user.username
    }
}