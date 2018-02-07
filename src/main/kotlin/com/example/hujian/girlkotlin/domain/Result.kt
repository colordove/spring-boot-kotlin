package com.example.hujian.girlkotlin.domain
/**
 * Http Response Outermost Layer Object
 */
class Result<T>{
    // Code
    var code: Int? = null
    // Message
    var message: String? = null
    // Data
    var data: T? = null
}