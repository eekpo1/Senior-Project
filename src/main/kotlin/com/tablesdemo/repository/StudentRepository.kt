package com.tablesdemo.repository

import com.tablesdemo.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource
interface StudentRepository : JpaRepository<Student, Long>