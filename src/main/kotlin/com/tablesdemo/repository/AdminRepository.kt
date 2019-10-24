package com.tablesdemo.repository

import com.tablesdemo.model.Admin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository


@Repository
@RepositoryRestResource
interface AdminRepository : JpaRepository<Admin, Long> {
    fun findByUsername(login: String): Admin
}
