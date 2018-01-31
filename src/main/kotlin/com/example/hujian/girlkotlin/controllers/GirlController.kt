package com.example.hujian.girlkotlin.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
@RestController
class GirlController {

    private val logger: Logger = LoggerFactory.getLogger(GirlController::class.java)

    @GetMapping(value = "girls")
    fun girlList() {
        logger.info("hello");
        return
    }

}