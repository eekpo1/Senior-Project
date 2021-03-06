package com.tablesdemo.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(@Id @Column(nullable = false, length = 64) var username: String? = "", var password: String? = "",
                var enabled: Boolean) : Serializable