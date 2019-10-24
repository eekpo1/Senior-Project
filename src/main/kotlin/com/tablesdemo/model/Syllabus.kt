package com.tablesdemo.model

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Embeddable


@Embeddable
class Syllabus(@Column(name = "current") var lastUpdate: LocalDate? = LocalDate.now(),
               @Column(name = "last") var currentUpate: LocalDate? = LocalDate.now(), var location: String? = "")