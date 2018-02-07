package com.example.hujian.girlkotlin.exception

class GirlException: RuntimeException() {
    var code: Int? = null;

    fun GirlException(code: Int, message: String) {
        this.code = code
    }
}