package com.tablesdemo.model

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Embeddable


@Embeddable
class Syllabus(@Column(name = "current") var lastUpdate: LocalDate? = LocalDate.now(),
               @Column(name = "last") var currentUpdate: LocalDate? = LocalDate.now(),
               @Column(name = "info") var instructorInfo: String = "", @Column(name = "meetings") var meetDates: String = "")