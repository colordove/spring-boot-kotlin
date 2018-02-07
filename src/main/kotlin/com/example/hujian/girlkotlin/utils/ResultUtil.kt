package com.example.hujian.girlkotlin.utils

import com.example.hujian.girlkotlin.domain.Result

object ResultUtil {

    fun <T>success(data: T?): Result<T> {
        val result = Result<T>()
        result.code = 0
        result.message = "success"
        result.data = data
        return result
    }

    fun error(code: Int?, message: String?): Result<Any> {
        val result = Result<Any>()
        result.code = code
        result.message = message
        return result
    }
}