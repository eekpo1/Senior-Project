package com.tablesdemo.repository

import com.tablesdemo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@RepositoryRestResource
@Repository
interface UserRepository : JpaRepository<User, String> {
    fun findByUsername(username: String): User

}