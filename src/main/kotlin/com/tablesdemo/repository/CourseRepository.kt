package com.tablesdemo.repository

import com.tablesdemo.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource
interface CourseRepository : JpaRepository<Course, Long>