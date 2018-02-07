package com.example.hujian.girlkotlin.handle

import com.example.hujian.girlkotlin.domain.Result
import com.example.hujian.girlkotlin.exception.GirlException
import com.example.hujian.girlkotlin.utils.ResultUtil
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

@ControllerAdvice
class ExceptionHandle() {
    @ExceptionHandler(value = [(Exception::class)])
    @ResponseBody
    fun handle(e: Exception): Result<Any> {
        return if (e is GirlException) {
            ResultUtil.error(e.code, e.message)
        } else {
            ResultUtil.error(-1, "Not Know Error")
        }
    }
}
