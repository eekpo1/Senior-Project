package com.tablesdemo.model

import javax.persistence.GeneratedValue
import javax.persistence.Id

// Haven't made this an entity yet. I dont think we need to
class Roster(@Id @GeneratedValue val id: Long = 0)