package com.tablesdemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Admin(@Id @GeneratedValue val id: Long, var fName: String, var lName: String, var login: String, var password: String)