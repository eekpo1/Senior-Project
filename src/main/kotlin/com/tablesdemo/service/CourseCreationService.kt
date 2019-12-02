package com.tablesdemo.service

import com.tablesdemo.model.Course
import com.tablesdemo.model.Student
import com.tablesdemo.model.Syllabus
import com.tablesdemo.repository.AdminRepository
import com.tablesdemo.repository.CourseRepository
import com.tablesdemo.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.security.Principal
import java.time.LocalDate

/**
 * This is For the Service Layer Business Logic with the students in the database. Since each student
 * has a coursesIN relation and each course has a students in relation, we will rectify that here.
 *
 * The intention of this service class is to handle the post logic
 */
@Service
class CourseCreationService {

    @Autowired lateinit var courseRepository: CourseRepository
    @Autowired lateinit var studentRepository: StudentRepository
    @Autowired lateinit var adminRepository: AdminRepository
    @Autowired lateinit var passwordService: PasswordService

    fun onCreate(course: Course, roster: List<Student>, principal: Principal) {
        /*
        We complete non nullable course details and relationships here
        Relationships: instructor : 1:1, roster: n:n
         */
        course.instructor = adminRepository.findByUsername(principal.name)
        course.syllabus = Syllabus()
        course.updated = true

        roster.forEach {it.username = it.firstName[0] + it.lastName}
        roster.forEach(::println)
        for (student in roster) {
            println(student.firstName)
            if (studentRepository.findByUsername(student.username!!).isPresent) {
                course.roster.add(student)
            }

        }
        courseRepository.saveAndFlush(course)
    }

    fun onCreate(course: Course, student: Student, principal: Principal) {
        course.instructor = adminRepository.findByUsername(principal.name)
        course.syllabus = Syllabus(LocalDate.now(), LocalDate.now(), "https://cs.csub.edu/~clei/teaching/19F4910.html")
        course.updated = true
        if (studentRepository.findByFirstNameAndLastName(student.firstName, student.lastName).isPresent) {
            course.roster.add(studentRepository.findByFirstNameAndLastName(student.firstName, student.lastName).get())
        }
        courseRepository.saveAndFlush(course)
    }


}