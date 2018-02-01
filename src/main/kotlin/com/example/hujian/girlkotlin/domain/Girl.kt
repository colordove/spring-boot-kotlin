package com.example.hujian.girlkotlin.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Girl {
    @Id
    @GeneratedValue
    var id: Int ?= null
    var cupSize: String ?= null
    var age: Int ?= null
}
