package com.example.hujian.girlkotlin.controllers

import com.example.hujian.girlkotlin.domain.Girl
import com.example.hujian.girlkotlin.domain.Result
import com.example.hujian.girlkotlin.repository.GirlRepository
import com.example.hujian.girlkotlin.utils.ResultUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping(value = "test")
class GirlController {

    private val logger: Logger = LoggerFactory.getLogger(GirlController::class.java)
    @Autowired
    private lateinit var girlRepository: GirlRepository


    @GetMapping(value = ["/girls"])
    fun girlList(): Result<List<Girl>> {
        logger.info("hello")
        return ResultUtil.success(this.girlRepository.findAll())
    }

    /**
     * Insert A Girl
     */
    @PostMapping(value = ["/girls"])
    fun girlAdd(@Valid girl: Girl, bindingResult: BindingResult): Result<Girl> {
        if (bindingResult.hasErrors()) {
            ResultUtil.error(-1, bindingResult.fieldError.defaultMessage)
        }
        return ResultUtil.success(this.girlRepository.save(girl))
    }

    /**
     * Find A Girl
     */
    @GetMapping(value = ["/girls/{id}"])
    fun girlFindOne(@PathVariable("id") id: Int): Result<Girl> {
        return ResultUtil.success(this.girlRepository.findOne(id))
    }

    /**
     * Update A Girl
     */
    @PostMapping(value = ["girlsUpdate"])
    fun girlUpdate(@RequestParam("id") id: Int,
                   @RequestParam("age") age: Int,
                   @RequestParam("cupSize") cupSize: String): Result<Girl> {
        val girl = Girl()
        girl.age = age
        girl.cupSize = cupSize
        girl.id = id
        return ResultUtil.success(this.girlRepository.save(girl))
    }

    /**
     * Delete A Girl
     */
    @PostMapping(value = ["girlsDelete"])
    fun girlDelete(@RequestParam("id") id: Int): Result<Any> {
        return ResultUtil.success(this.girlRepository.delete(id))
    }
}