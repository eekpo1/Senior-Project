package com.tablesdemo.repository

import com.tablesdemo.model.Roles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@RepositoryRestResource
@Repository
interface RolesRepository : JpaRepository<Roles, String>