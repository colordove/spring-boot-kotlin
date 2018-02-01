package com.example.hujian.girlkotlin.controllers

import com.example.hujian.girlkotlin.domain.Girl
import com.example.hujian.girlkotlin.repository.GirlRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class GirlController {

    private val logger: Logger = LoggerFactory.getLogger(GirlController::class.java)
    @Autowired
    private lateinit var girlRepository: GirlRepository


    @GetMapping(value = ["/girls"])
    fun girlList(): List<Girl> {
        logger.info("hello")
        return this.girlRepository.findAll()
    }

    /**
     * Insert A Girl
     */
    @PostMapping(value = ["/girls"])
    fun girlAdd(@Valid girl: Girl, bindingResult: BindingResult): Girl {
        if (bindingResult.hasErrors()) {
            this.logger.error(bindingResult.fieldError.defaultMessage)
        }
        return this.girlRepository.save(girl)
    }

    /**
     * Find A Girl
     */
    @GetMapping(value = ["/girls/{id}"])
    fun girlFindOne(@PathVariable("id") id: Int): Girl {
        return this.girlRepository.findOne(id)
    }

    /**
     * Update A Girl
     */
    @PostMapping(value = ["girlsUpdate"])
    fun girlUpdate(@RequestParam("id") id: Int,
                   @RequestParam("age") age: Int,
                   @RequestParam("cupSize") cupSize: String): Girl {
        val girl = Girl()
        girl.age = age
        girl.cupSize = cupSize
        girl.id = id
        return this.girlRepository.save(girl)
    }

    /**
     * Delete A Girl
     */
    @PostMapping(value = ["girlsDelete"])
    fun girlDelete(@RequestParam("id") id: Int) {
        this.girlRepository.delete(id)
    }
}