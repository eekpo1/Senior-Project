package com.tablesdemo.model

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Embeddable


@Embeddable
class Syllabus(@Column(name = "current") var lastUpdate: LocalDate? = LocalDate.now(),
               @Column(name = "last") var currentUpdate: LocalDate? = LocalDate.now(),
               @Column(name = "info", length = 500) var instructorInfo: String = "", @Column(name = "meetings", length = 500) var meetDates: String = "")