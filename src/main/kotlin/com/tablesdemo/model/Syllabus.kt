package com.tablesdemo.model

import java.time.LocalDate
import javax.persistence.Embeddable


@Embeddable
class Syllabus(var lastUpdate: LocalDate = LocalDate.now(), var location: String)