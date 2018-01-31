package com.example.hujian.girlkotlin.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value="demo")
class HelloWorldController {
    @GetMapping("hello")
    fun say(@RequestParam(value="id", required = false, defaultValue = "0") myId: Int): String {
        return "id: $myId";
    }
}
