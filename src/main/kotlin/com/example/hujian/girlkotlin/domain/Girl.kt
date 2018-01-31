package com.example.hujian.girlkotlin.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Girl {
    @Id
    @GeneratedValue
    var id: Int = 0
    var cupSize: String = "A"
    var age: String = "20"
}
