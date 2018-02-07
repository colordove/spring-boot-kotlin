package com.example.hujian.girlkotlin.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class HttpAspect {
    val logger: Logger = LoggerFactory.getLogger(HttpAspect::class.java)

    @Pointcut("execution(public * com.hujian.girl.controllers.GirlController.*(..)))")
    fun log() {

    }
}