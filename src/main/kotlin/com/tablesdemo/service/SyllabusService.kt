package com.tablesdemo.service

import com.tablesdemo.model.Course
import com.tablesdemo.model.SyllabusWrapper
import com.tablesdemo.repository.CourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SyllabusService {
    @Autowired
    lateinit var courseRepository: CourseRepository


    fun createSyllabus(course: Course, wrapper: SyllabusWrapper) {
        val instructor = course.instructor
        var template = "Welcome to ${course.name}.\n" +
                "\n" +
                "Instructor: Professor ${instructor.firstName} ${instructor.lastName}\n" +
                "Contact Phone Number: ${wrapper.phone}\n" +
                "\n" +
                "Office Hours:" +
                "    • ${wrapper.officeHrs} --------------- ${wrapper.start} - ${wrapper.end}\n" +
                "    • __\n" +
                "\n" +
                "The meeting days are shown below for this class:\t" +
                "\n" +
                "    •  ${wrapper.Assignments} ---------- ${wrapper.due}\n" +
                "    •  \n" +
                "    • "
        var syllabusCourse = courseRepository.findByNameAndSection(course.name, course.section)
        syllabusCourse.syllabus!!.instructorInfo = template
        courseRepository.saveAndFlush(syllabusCourse)
        println(template)

    }


}